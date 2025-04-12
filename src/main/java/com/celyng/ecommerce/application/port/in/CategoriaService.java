package com.celyng.ecommerce.application.port.in;

import com.celyng.ecommerce.domain.models.Categoria;
import com.celyng.ecommerce.infrastructure.entypoint.models.CategoriaRequest;

public interface CategoriaService {
    Categoria crearCategoria(CategoriaRequest categoriaRequest);
}
