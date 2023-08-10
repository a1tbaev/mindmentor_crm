package kg.nsi.crm.controller;

import kg.nsi.crm.dto.request.AuthenticateRequest;
import kg.nsi.crm.dto.response.AuthenticateResponse;
import kg.nsi.crm.service.AuthenticateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticateService authenticateService;

    @PostMapping("/post")
    public AuthenticateResponse authenticate (@RequestBody AuthenticateRequest authenticateRequest){
        return authenticateService.authenticate(authenticateRequest);
    }
}
