package com.celyng.ecommerce.infrastructure.entypoint.models;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ProductoRequest {
    private String nombre;
    private String descripcion;
    private String referencia;
    private Double precio;
    private int stock;
    private boolean status;
    private UUID marcaId;
    private UUID categoriaId;
    private List<ImagenRequest> imagenes;
}
