package com.partidoya.api.security.controller;


import com.partidoya.api.security.dto.AuthReq;
import com.partidoya.api.security.dto.AuthRes;
import com.partidoya.api.security.dto.RegisterReq;
import com.partidoya.api.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthRes> login(@RequestBody @Valid AuthReq authReq) {
        return ResponseEntity.ok(authService.authenticate(authReq));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthRes> register(@RequestBody @Valid RegisterReq registerReq) {
        return ResponseEntity.ok(authService.register(registerReq));
    }
}
