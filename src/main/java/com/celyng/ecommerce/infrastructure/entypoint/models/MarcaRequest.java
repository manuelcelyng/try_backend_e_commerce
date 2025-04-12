package com.celyng.ecommerce.infrastructure.entypoint.models;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class MarcaRequest {

    private String nombre;
    private String descripcion;

}
