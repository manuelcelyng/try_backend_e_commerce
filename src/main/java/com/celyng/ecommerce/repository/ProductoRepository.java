package com.celyng.ecommerce.repository;

import com.celyng.ecommerce.repository.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductoRepository extends JpaRepository<ProductoEntity, UUID> {
}
