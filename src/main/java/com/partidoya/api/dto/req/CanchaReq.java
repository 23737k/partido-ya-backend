package com.partidoya.api.dto.req;

import java.util.List;

public record CanchaReq(
    String nombre,
    String direccion,
    String barrio,
    double lat,
    double lon,
    List<Integer> tiposDeCanchas
) {
}
