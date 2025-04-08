package com.celyng.ecommerce.domain.models;


import lombok.Data;

import java.util.UUID;

@Data
public class Marca {

    UUID marcaId;
    String nombre;
    String descripcion;

}
