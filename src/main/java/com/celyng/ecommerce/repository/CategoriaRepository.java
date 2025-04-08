package com.celyng.ecommerce.repository;

import com.celyng.ecommerce.repository.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, UUID> {
}
