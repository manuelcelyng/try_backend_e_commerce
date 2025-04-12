package com.celyng.ecommerce.application.mapper;

import com.celyng.ecommerce.domain.models.Producto;
import com.celyng.ecommerce.domain.valueObject.Money;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.ImagenProductoEntity;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.ProductoEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProductoMapper {

    public static Producto toDomain(ProductoEntity entity) {
        return Producto.builder()
                .productoId(entity.getProductoId())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .referencia(entity.getReferencia())
                .precio(new Money(BigDecimal.valueOf(entity.getPrecio())))
                .stock(entity.getStock())
                .status(entity.isStatus())
                .marca(MarcaMapper.toDomain(entity.getMarca()))
                .categoria(CategoriaMapper.toDomain(entity.getCategoria()))
                .imagenes(entity.getImagenes().stream()
                        .map(ImagenProductoMapper::toDomain)
                        .toList())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static ProductoEntity toEntity(Producto domain) {
        ProductoEntity entity = ProductoEntity.builder()
                .productoId(domain.getProductoId())
                .nombre(domain.getNombre())
                .descripcion(domain.getDescripcion())
                .referencia(domain.getReferencia())
                .precio(domain.getPrecio().getCantidad().doubleValue())
                .stock(domain.getStock())
                .status(domain.isStatus())
                .marca(MarcaMapper.toEntity(domain.getMarca()))
                .categoria(CategoriaMapper.toEntity(domain.getCategoria()))
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();

        // Set imágenes y asignar relación inversa
        List<ImagenProductoEntity> imagenes = domain.getImagenes().stream()
                .map(i -> {
                    ImagenProductoEntity imagenEntity = ImagenProductoMapper.toEntity(i);
                    imagenEntity.setProducto(entity); // relación inversa
                    return imagenEntity;
                }).collect(Collectors.toList());

        entity.setImagenes(imagenes);
        return entity;
    }
}

