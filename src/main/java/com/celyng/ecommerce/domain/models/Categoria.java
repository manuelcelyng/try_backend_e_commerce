package com.celyng.ecommerce.domain.models;


import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
public class Categoria {

    UUID categoriaId;
    String nombre;
    String descripcion;
    ZonedDateTime createdAt;
    ZonedDateTime updatedAt;
}
