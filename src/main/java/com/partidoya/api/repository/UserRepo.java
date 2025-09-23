package com.partidoya.api.repository;

import com.partidoya.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
