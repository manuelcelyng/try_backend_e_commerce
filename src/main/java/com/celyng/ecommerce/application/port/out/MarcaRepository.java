package com.celyng.ecommerce.application.port.out;

import com.celyng.ecommerce.domain.models.Marca;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.MarcaEntity;

import java.util.List;

public interface MarcaRepository {

    MarcaEntity save(Marca marca);

    List<MarcaEntity> getAll();
}
