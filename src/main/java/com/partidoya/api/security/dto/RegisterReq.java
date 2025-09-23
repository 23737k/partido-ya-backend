package com.partidoya.api.security.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterReq (
//    @NotBlank
//    @Schema(example = "John")
//    String nombre,
//
//    @NotBlank
//    @Schema(example = "Doe")
//    String apellido,

    @Email
    @NotBlank
    @Schema(example = "john-doe@gmail.com")
    String email,

    @NotBlank
    @Schema(example = "P@ssw0rd!")
    String password
){}