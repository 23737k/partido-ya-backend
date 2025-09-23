package com.partidoya.api.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record AuthReq(
    @NotBlank
    @Schema(example = "john-doe@gmail.com")
    String email,

    @NotBlank
    @Schema(example = "P@ssw0rd!")
    String password
) {}
