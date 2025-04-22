package com.celyng.ecommerce.infrastructure.drivenadapter.repository;

import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MarcaJpaRepository extends JpaRepository<MarcaEntity, UUID> {
}
