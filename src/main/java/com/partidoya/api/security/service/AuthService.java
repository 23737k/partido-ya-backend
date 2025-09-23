package com.partidoya.api.security.service;

import com.partidoya.api.exception.UserAlreadyExistsException;
import com.partidoya.api.model.Usuario;
import com.partidoya.api.security.dto.AuthReq;
import com.partidoya.api.security.dto.AuthRes;
import com.partidoya.api.security.dto.RegisterReq;
import com.partidoya.api.security.jwt.JwtService;
import com.partidoya.api.security.token.Token;
import com.partidoya.api.security.token.TokenService;
import com.partidoya.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtService jwtService;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @Transactional
    public AuthRes authenticate(AuthReq authReq) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(authReq.email(),authReq.password());
        UserDetails userDetails = (UserDetails) authenticationManager.authenticate(authentication).getPrincipal();

        Token token = new Token(jwtService.getAccessToken(userDetails));
        tokenService.save(token);
        return new AuthRes(token.getToken());
    }

    @Transactional
    public AuthRes register(RegisterReq req) {
        if(userService.userExists(req.email()))
            throw new UserAlreadyExistsException("This email is already registered");

        Usuario usuario = userService.crearUsuarioCliente(req);

        Token token = new Token(jwtService.getAccessToken(usuario));
        tokenService.save(token);
        return new AuthRes(token.getToken());

    }
}