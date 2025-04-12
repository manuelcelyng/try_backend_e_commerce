package com.celyng.ecommerce.application;

import com.celyng.ecommerce.application.mapper.ProductoMapper;
import com.celyng.ecommerce.domain.models.Producto;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.ProductoJpaRepository;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.ProductoEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Component
@AllArgsConstructor
public class ProductoServiceImplHelper  {

    private final ProductoJpaRepository productoRepository;

    @Transactional
    public ProductoEntity saveProducto(Producto producto) {
        ProductoEntity productoEntity = ProductoMapper.toEntity(producto);
        return productoRepository.save(productoEntity);
    }

    public void deleteById(UUID id) {
        productoRepository.deleteById(id);
    }
}
