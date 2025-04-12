package com.celyng.ecommerce.application.mapper;

import com.celyng.ecommerce.domain.models.Marca;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.MarcaEntity;

public class MarcaMapper {
    public static Marca toDomain(MarcaEntity entity) {
        return Marca.builder()
                .marcaId(entity.getMarcaId())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static MarcaEntity toEntity(Marca domain) {
        return MarcaEntity.builder()
                .marcaId(domain.getMarcaId())
                .nombre(domain.getNombre())
                .descripcion(domain.getDescripcion())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }
}

