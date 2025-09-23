package com.partidoya.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@SecurityRequirement(name = "bearer-jwt")
public class HelloController {
    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Felicidades, estas autenticado");
    }
}
