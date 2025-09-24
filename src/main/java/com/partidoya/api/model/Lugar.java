package com.partidoya.api.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Lugar {
    private String direccion;
    private String barrio;
    private double lat;
    private double lon;
}
