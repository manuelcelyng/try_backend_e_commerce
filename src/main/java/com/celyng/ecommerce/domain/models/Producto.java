package com.celyng.ecommerce.domain.models;

import com.celyng.ecommerce.domain.valueObject.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.security.Timestamp;
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
    Timestamp createdAt;
    Timestamp updatedAt;


}
