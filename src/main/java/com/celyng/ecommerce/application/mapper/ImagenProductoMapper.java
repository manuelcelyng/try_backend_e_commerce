package com.celyng.ecommerce.application.mapper;

import com.celyng.ecommerce.domain.models.ImagenProducto;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.ImagenProductoEntity;

public class ImagenProductoMapper {

    public static ImagenProducto toDomain(ImagenProductoEntity entity) {
        return ImagenProducto.builder()
                .imagenId(entity.getImagenId())
                .productoId(entity.getProducto().getProductoId()) // solo referencia
                .url(entity.getUrl())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static ImagenProductoEntity toEntity(ImagenProducto domain) {
        return ImagenProductoEntity.builder()
                .imagenId(domain.getImagenId())
                .url(domain.getUrl())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }
}

