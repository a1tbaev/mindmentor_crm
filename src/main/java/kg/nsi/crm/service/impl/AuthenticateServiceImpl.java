package kg.nsi.crm.service.impl;

import jakarta.transaction.Transactional;
import kg.nsi.crm.config.jwt.JwtService;
import kg.nsi.crm.dto.request.AuthenticateRequest;
import kg.nsi.crm.dto.response.AuthenticateResponse;
import kg.nsi.crm.entity.User;
import kg.nsi.crm.repository.UserRepository;
import kg.nsi.crm.service.AuthenticateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AuthenticateServiceImpl implements AuthenticateService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthenticateResponse authenticate(AuthenticateRequest request) {

        User userInfo = userRepository.findByUsername(request.userName())
                .orElseThrow(() -> {
                    log.error(String.format("Пользователь с адресом электронной почты %s не существует", request.userName()));
                    try {
                        throw new ChangeSetPersister.NotFoundException();
                    } catch (ChangeSetPersister.NotFoundException e) {
                        throw new RuntimeException(e);
                    }
                });
        if (!passwordEncoder.matches(request.password(), userInfo.getPassword())) {
            log.error("Пароль не подходит");
        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.userName(),
                        request.password()
                )
        );
        log.info(String.format("Пользователь %s успешно аутентифицирован", userInfo.getUsername()));
        String token = jwtService.generateToken(userInfo);

        return AuthenticateResponse.builder()
                .userName(userInfo.getUsername())
                .role(userInfo.getRole())
                .token(token)
                .build();
    }
}
