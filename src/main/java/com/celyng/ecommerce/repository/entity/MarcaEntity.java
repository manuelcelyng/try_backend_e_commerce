package com.celyng.ecommerce.repository.entity;

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
    private UUID marcaId;

    private String nombre;
    private String descripcion;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}