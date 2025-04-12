package com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "imagenes_producto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImagenProductoEntity {

    @Id
    @GeneratedValue
    private UUID imagenId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private ProductoEntity producto;

    private String url;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}