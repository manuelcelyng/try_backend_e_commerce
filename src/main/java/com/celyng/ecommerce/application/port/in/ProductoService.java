package com.celyng.ecommerce.application.port.in;

import com.celyng.ecommerce.domain.models.Producto;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.ProductoEntity;
import com.celyng.ecommerce.infrastructure.entypoint.models.ProductoRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ProductoService {

    Producto crearProducto(ProductoRequest productoRequest);

    void eliminarProducto(UUID id);

    List<Producto> obtenerTodos();

    Producto actualizarProducto(String id, ProductoRequest request);
}
