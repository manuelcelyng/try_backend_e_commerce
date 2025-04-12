package com.celyng.ecommerce.application.port.in;

import com.celyng.ecommerce.domain.models.Marca;
import com.celyng.ecommerce.infrastructure.entypoint.models.MarcaRequest;

public interface MarcaService {
    Marca crearMarca(MarcaRequest marcaRequest);
}
