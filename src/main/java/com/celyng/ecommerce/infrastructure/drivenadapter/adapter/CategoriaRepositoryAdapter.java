package com.celyng.ecommerce.infrastructure.drivenadapter.adapter;


import com.celyng.ecommerce.application.mapper.CategoriaMapper;
import com.celyng.ecommerce.application.port.out.CategoriaRepository;
import com.celyng.ecommerce.domain.models.Categoria;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.CategoriaJpaRepository;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.CategoriaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CategoriaRepositoryAdapter implements CategoriaRepository {

    private final CategoriaJpaRepository repository;

    @Override
    public CategoriaEntity save(Categoria categoria) {
        CategoriaEntity entity = CategoriaMapper.toEntity(categoria);
        return repository.save(entity);
    }

    @Override
    public List<CategoriaEntity> getAll() {
        return repository.findAll();
    }
}
