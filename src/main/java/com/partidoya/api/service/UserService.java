package com.partidoya.api.service;

import com.partidoya.api.model.Usuario;
import com.partidoya.api.repository.UserRepo;
import com.partidoya.api.security.dto.RegisterReq;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public Usuario findUserByEmail(String email) {
        return  userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found"));
    }

    public boolean userExists(String email) {
        return userRepo.findByEmail(email).isPresent();
    }

    @Transactional
    public Usuario crearUsuarioCliente(RegisterReq req){
        Usuario usuario = Usuario.builder()
                .email(req.email())
                .password(passwordEncoder.encode(req.password()))
                .build();
        return userRepo.save(usuario);
    }

}
