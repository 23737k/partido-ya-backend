package com.partidoya.api.dto.res;

import java.util.List;

public record CanchaRes(
    int id,
    String nombre,
    String direccion,
    String barrio,
    double lat,
    double lon,
    List<Integer> tiposDeCanchas
) {
}
