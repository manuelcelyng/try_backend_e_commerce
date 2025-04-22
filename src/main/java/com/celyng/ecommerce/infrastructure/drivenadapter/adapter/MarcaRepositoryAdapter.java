package com.celyng.ecommerce.infrastructure.drivenadapter.adapter;

import com.celyng.ecommerce.application.mapper.MarcaMapper;
import com.celyng.ecommerce.application.port.out.MarcaRepository;
import com.celyng.ecommerce.domain.models.Marca;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.MarcaJpaRepository;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.MarcaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@AllArgsConstructor
public class MarcaRepositoryAdapter implements MarcaRepository {

    private final MarcaJpaRepository repository;

    @Override
    public MarcaEntity save(Marca marca) {
        MarcaEntity entity = MarcaMapper.toEntity(marca);
        return repository.save(entity);
    }

    @Override
    public List<MarcaEntity> getAll() {
        return repository.findAll();
    }
}
