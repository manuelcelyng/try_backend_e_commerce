package com.celyng.ecommerce.domain.models;

import com.celyng.ecommerce.domain.valueObject.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
public class Producto {

    UUID productoId;
    String nombre;
    String descripcion;
    String referencia;
    Money precio;
    int stock;
    boolean status;
    ZonedDateTime createdAt;
    ZonedDateTime updatedAt;

    Marca marca; // referencia (no modificable desde Producto)
    Categoria categoria; // referencia (no modificable desde Producto)

    List<ImagenProducto> imagenes; // parte del agregado


}
