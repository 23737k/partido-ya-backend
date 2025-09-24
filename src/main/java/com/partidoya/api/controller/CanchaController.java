package com.partidoya.api.controller;

import com.partidoya.api.dto.req.CanchaReq;
import com.partidoya.api.dto.res.CanchaRes;
import com.partidoya.api.repository.specification.CanchaFiltro;
import com.partidoya.api.service.CanchaService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/canchas")
@RequiredArgsConstructor
public class CanchaController {
    private final CanchaService canchaService;

    @PostMapping
    public ResponseEntity<CanchaRes> save(@RequestBody CanchaReq cancha) {
        return new ResponseEntity<>(canchaService.create(cancha), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CanchaRes>> findAll(@ParameterObject @ModelAttribute
                                                   CanchaFiltro filtro) {
        return ResponseEntity.ok(canchaService.getCanchas(filtro));
    }

}
