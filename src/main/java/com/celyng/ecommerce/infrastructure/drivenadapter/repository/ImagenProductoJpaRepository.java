package com.celyng.ecommerce.infrastructure.drivenadapter.repository;

import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.ImagenProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImagenProductoJpaRepository extends JpaRepository<ImagenProductoEntity, UUID> {
}
