package com.celyng.ecommerce.application.port.out;

import com.celyng.ecommerce.domain.models.Marca;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.MarcaEntity;

public interface MarcaRepository {

    MarcaEntity save(Marca marca);
}
