package com.test.authentication.Controller;

import com.test.authentication.Service.AuthenticationService;
import com.test.authentication.model.auth.AuthResponse;
import com.test.authentication.model.auth.AuthenticateRequest;
import com.test.authentication.model.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest registerRequest
            ){

        return ResponseEntity.ok(service.register(registerRequest));

    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> register(
            @RequestBody AuthenticateRequest authRequest){

        return ResponseEntity.ok(service.authenticate(authRequest));

    }
}
