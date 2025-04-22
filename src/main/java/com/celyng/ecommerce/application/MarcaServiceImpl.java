package com.celyng.ecommerce.application;

import com.celyng.ecommerce.application.mapper.MarcaMapper;
import com.celyng.ecommerce.application.port.in.MarcaService;
import com.celyng.ecommerce.application.port.out.MarcaRepository;
import com.celyng.ecommerce.domain.models.Marca;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.MarcaEntity;
import com.celyng.ecommerce.infrastructure.entypoint.models.MarcaRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository repository;


    @Override
    public Marca crearMarca(MarcaRequest marcaRequest) {
        Marca marca = Marca.builder()
                .nombre(marcaRequest.getNombre())
                .descripcion(marcaRequest.getDescripcion())
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();

        return MarcaMapper.toDomain(repository.save(marca));
    }

    @Override
    public List<MarcaEntity> getAll() {
        return repository.getAll();
    }
}
