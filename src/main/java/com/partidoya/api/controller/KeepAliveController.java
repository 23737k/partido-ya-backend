package com.partidoya.api.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RestController
@RequestMapping("/api/keepAlive")
public class KeepAliveController {

    @GetMapping
    public ResponseEntity<String> keepAlive() {
        return ResponseEntity.ok("I'm alive!");
    }
}
