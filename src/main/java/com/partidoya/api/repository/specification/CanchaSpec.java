package com.partidoya.api.repository.specification;

import com.partidoya.api.model.Cancha;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CanchaSpec {

    public Specification<Cancha> findAllSpecification(CanchaFiltro filtro) {
        Specification<Cancha> spec = (root, query, cb) -> cb.conjunction();;
        if(filtro.barrio()!=null){
            spec = spec.and(barrioEquals(filtro.barrio()));
        }
        if(filtro.tiposDeCancha()!=null){
            spec = spec.and(tiposDeCanchaIn(filtro.tiposDeCancha()));
        }
        return spec;
    }

    public Specification<Cancha> barrioEquals(String barrio){
        return (root, query, cb) -> cb.equal(
           cb.function("unaccent", String.class,
               cb.lower(root.get("lugar").get("barrio"))
           ),
           cb.function("unaccent", String.class,
               cb.literal(barrio.toLowerCase())
           )
       );
    }

    public Specification<Cancha> tiposDeCanchaIn(List<Integer> tiposDeCanchas) {
        return (root, query, cb) -> {
            query.distinct(true);
            return root.join("tiposDeCanchas").in(tiposDeCanchas);
        };
    }
}
