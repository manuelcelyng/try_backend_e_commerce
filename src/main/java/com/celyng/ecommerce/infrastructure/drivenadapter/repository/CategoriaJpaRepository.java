package com.celyng.ecommerce.infrastructure.drivenadapter.repository;

import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaJpaRepository extends JpaRepository<CategoriaEntity, UUID> {
}
