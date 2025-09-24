package com.partidoya.api.repository;

import com.partidoya.api.model.Cancha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CanchaRepo extends JpaRepository<Cancha, Integer> ,
    JpaSpecificationExecutor<Cancha> {

}
