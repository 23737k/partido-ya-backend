package com.partidoya.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenNotFoundException extends RuntimeException {
    private String message;
}
