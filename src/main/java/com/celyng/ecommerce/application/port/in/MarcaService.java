package com.celyng.ecommerce.application.port.in;

import com.celyng.ecommerce.domain.models.Marca;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.MarcaEntity;
import com.celyng.ecommerce.infrastructure.entypoint.models.MarcaRequest;

import java.util.List;

public interface MarcaService {
    Marca crearMarca(MarcaRequest marcaRequest);

    List<MarcaEntity> getAll();
}
