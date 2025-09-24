package com.partidoya.api.mapper;

import com.partidoya.api.dto.req.CanchaReq;
import com.partidoya.api.dto.res.CanchaRes;
import com.partidoya.api.model.Cancha;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CanchaMapper {
    @Mapping(source = "lugar.direccion", target = "direccion")
    @Mapping(source = "lugar.barrio", target = "barrio")
    @Mapping(source = "lugar.lat", target = "lat")
    @Mapping(source = "lugar.lon", target = "lon")
    CanchaRes toRes(Cancha cancha);
    Cancha toEntity(CanchaReq cancha);
}
