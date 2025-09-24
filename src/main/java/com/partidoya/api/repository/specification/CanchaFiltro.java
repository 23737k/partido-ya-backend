package com.partidoya.api.repository.specification;

import java.util.List;

public record CanchaFiltro(
    String barrio,
    List<Integer> tiposDeCancha
) {
}
