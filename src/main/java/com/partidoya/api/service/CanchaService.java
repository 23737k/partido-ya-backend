package com.partidoya.api.service;

import com.partidoya.api.dto.req.CanchaReq;
import com.partidoya.api.dto.res.CanchaRes;
import com.partidoya.api.mapper.CanchaMapper;
import com.partidoya.api.model.Cancha;
import com.partidoya.api.repository.CanchaRepo;
import com.partidoya.api.repository.specification.CanchaFiltro;
import com.partidoya.api.repository.specification.CanchaSpec;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CanchaService {
    private final CanchaRepo canchaRepo;
    private final CanchaMapper canchaMapper;
    private final CanchaSpec  canchaSpec;

    public CanchaRes create(CanchaReq cancha) {
        return canchaMapper.toRes(canchaRepo.save(canchaMapper.toEntity(cancha)));
    }

    public List<CanchaRes> getCanchas(CanchaFiltro filtro) {
        Specification<Cancha> spec = canchaSpec.findAllSpecification(filtro);
        return canchaRepo.findAll(spec).stream().map(canchaMapper::toRes).toList();
    }
}
