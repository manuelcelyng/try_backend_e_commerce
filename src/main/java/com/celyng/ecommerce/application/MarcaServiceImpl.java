package com.celyng.ecommerce.application;

import com.celyng.ecommerce.application.mapper.MarcaMapper;
import com.celyng.ecommerce.application.port.in.MarcaService;
import com.celyng.ecommerce.application.port.out.MarcaRepository;
import com.celyng.ecommerce.domain.models.Marca;
import com.celyng.ecommerce.infrastructure.entypoint.models.MarcaRequest;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
public class MarcaServiceImpl implements MarcaService {

    MarcaRepository repository;


    @Override
    public Marca crearMarca(MarcaRequest marcaRequest) {
        Marca marca = Marca.builder()
                .marcaId(UUID.randomUUID())
                .nombre(marcaRequest.getNombre())
                .descripcion(marcaRequest.getDescripcion())
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();

        return MarcaMapper.toDomain(repository.save(marca));
    }
}
