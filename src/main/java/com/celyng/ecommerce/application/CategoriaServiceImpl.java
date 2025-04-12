package com.celyng.ecommerce.application;

import com.celyng.ecommerce.application.mapper.CategoriaMapper;
import com.celyng.ecommerce.application.port.in.CategoriaService;
import com.celyng.ecommerce.application.port.out.CategoriaRepository;
import com.celyng.ecommerce.domain.models.Categoria;
import com.celyng.ecommerce.infrastructure.entypoint.models.CategoriaRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.UUID;


@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public Categoria crearCategoria(CategoriaRequest categoriaRequest) {

        Categoria categoria = Categoria.builder()
                .nombre(categoriaRequest.getNombre())
                .descripcion(categoriaRequest.getDescripcion())
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();

        return CategoriaMapper.toDomain(categoriaRepository.save(categoria));
    }
}
