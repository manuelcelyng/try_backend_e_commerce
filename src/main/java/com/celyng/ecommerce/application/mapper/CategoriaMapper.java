package com.celyng.ecommerce.application.mapper;

import com.celyng.ecommerce.domain.models.Categoria;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.CategoriaEntity;

public class CategoriaMapper {

    public static Categoria toDomain(CategoriaEntity entity) {
        if (entity == null) return null;

        return Categoria.builder()
                .categoriaId(entity.getCategoriaId())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static CategoriaEntity toEntity(Categoria domain) {
        if (domain == null) return null;

        return CategoriaEntity.builder()
                .categoriaId(domain.getCategoriaId())
                .nombre(domain.getNombre())
                .descripcion(domain.getDescripcion())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }
}

