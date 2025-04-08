package com.celyng.ecommerce.domain.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ImagenProducto {

    UUID imagen_id;
    UUID producto_id;
    String url;

}
