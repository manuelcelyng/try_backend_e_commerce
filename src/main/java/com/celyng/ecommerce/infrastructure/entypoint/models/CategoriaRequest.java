package com.celyng.ecommerce.infrastructure.entypoint.models;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CategoriaRequest {

    private String nombre;
    private String descripcion;

}
