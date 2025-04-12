package com.celyng.ecommerce.application;

import com.celyng.ecommerce.application.mapper.ProductoMapper;
import com.celyng.ecommerce.domain.models.Producto;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.ProductoJpaRepository;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.ProductoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class ProductoServiceImplHelper  {

    private ProductoJpaRepository productoRepository;

    @Transactional
    public ProductoEntity saveProducto(Producto producto) {
        ProductoEntity productoEntity = ProductoMapper.toEntity(producto);
        return productoRepository.save(productoEntity);
    }

}
