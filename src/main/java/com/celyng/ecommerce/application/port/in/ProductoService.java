package com.celyng.ecommerce.application.port.in;

import com.celyng.ecommerce.domain.models.Producto;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.ProductoEntity;
import com.celyng.ecommerce.infrastructure.entypoint.models.ProductoRequest;
import org.springframework.http.ResponseEntity;

public interface ProductoService {

    Producto crearProducto(ProductoRequest productoRequest);
}
