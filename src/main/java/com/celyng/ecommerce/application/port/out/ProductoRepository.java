package com.celyng.ecommerce.application.port.out;

import com.celyng.ecommerce.domain.models.Producto;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.ProductoEntity;

public interface ProductoRepository {
    ProductoEntity save(Producto producto);
}
