package com.celyng.ecommerce.application.port.out;

import com.celyng.ecommerce.domain.models.Categoria;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.CategoriaEntity;

public interface CategoriaRepository {

    CategoriaEntity save(Categoria categoria);
}
