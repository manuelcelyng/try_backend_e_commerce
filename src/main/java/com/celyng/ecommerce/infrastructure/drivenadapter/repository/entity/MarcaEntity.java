package com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "marcas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarcaEntity {

    @Id
    @GeneratedValue
    @Column(name = "marca_id")
    private UUID marcaId;

    private String nombre;
    private String descripcion;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;
    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;
}