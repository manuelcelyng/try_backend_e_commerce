package com.celyng.ecommerce.repository;

import com.celyng.ecommerce.repository.entity.MarcaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MarcaRepository extends CrudRepository<MarcaEntity, UUID> {
}
