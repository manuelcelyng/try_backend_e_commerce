package com.celyng.ecommerce.infrastructure.drivenadapter.adapter;

import com.celyng.ecommerce.application.mapper.ProductoMapper;
import com.celyng.ecommerce.application.port.out.ProductoRepository;
import com.celyng.ecommerce.domain.models.Producto;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.ProductoJpaRepository;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.ProductoEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProductoRepositoryAdapter implements ProductoRepository {

    private final ProductoJpaRepository repository;

    @Override
    public ProductoEntity save(Producto producto){
        ProductoEntity entity = ProductoMapper.toEntity(producto);
        return repository.save(entity);
    }

}
