package com.celyng.ecommerce.application.port.in;

import com.celyng.ecommerce.domain.models.Categoria;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.CategoriaEntity;
import com.celyng.ecommerce.infrastructure.entypoint.models.CategoriaRequest;

import java.util.List;

public interface CategoriaService {
    Categoria crearCategoria(CategoriaRequest categoriaRequest);

    List<CategoriaEntity> getAll();
}
