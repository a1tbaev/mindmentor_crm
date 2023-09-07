package kg.nsi.crm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.nsi.crm.dto.request.AuthenticateRequest;
import kg.nsi.crm.dto.response.AuthenticateResponse;
import kg.nsi.crm.service.AuthenticateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "Auth", description = "The User Authentication API")
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticateService authenticateService;

    @Operation(summary = "User authentication", description = "This method to authenticate the user")
    @PostMapping("/post")
    public AuthenticateResponse authenticate (@RequestBody AuthenticateRequest authenticateRequest){
        return authenticateService.authenticate(authenticateRequest);
    }
}
