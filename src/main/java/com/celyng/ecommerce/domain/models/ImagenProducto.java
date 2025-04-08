package com.celyng.ecommerce.domain.models;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
public class ImagenProducto {

    UUID imagenId;
    UUID productoId;
    String url;
    ZonedDateTime createdAt;
    ZonedDateTime updatedAt;

}
