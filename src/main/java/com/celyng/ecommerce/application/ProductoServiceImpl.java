package com.celyng.ecommerce.application;

import com.celyng.ecommerce.application.port.in.ProductoService;
import com.celyng.ecommerce.infrastructure.entypoint.models.ProductoRequest;
import com.celyng.ecommerce.domain.exception.ProductoDomainException;
import com.celyng.ecommerce.domain.models.Categoria;
import com.celyng.ecommerce.domain.models.ImagenProducto;
import com.celyng.ecommerce.domain.models.Marca;
import com.celyng.ecommerce.domain.models.Producto;
import com.celyng.ecommerce.domain.valueObject.Money;
import com.celyng.ecommerce.application.mapper.CategoriaMapper;
import com.celyng.ecommerce.application.mapper.MarcaMapper;
import com.celyng.ecommerce.application.mapper.ProductoMapper;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.CategoriaJpaRepository;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.MarcaJpaRepository;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.CategoriaEntity;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.MarcaEntity;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.ProductoEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {


    private final MarcaJpaRepository marcaRepository;
    private final CategoriaJpaRepository categoriaRepository;
    private final ProductoServiceImplHelper productoServiceImplHelper;


    public Producto crearProducto(ProductoRequest request) {

        Marca marca = MarcaMapper.toDomain(checkMarca(request.getMarcaId()));
        Categoria categoria = CategoriaMapper.toDomain(checkCategoria(request.getCategoriaId()));

        Producto producto = Producto.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .referencia(request.getReferencia())
                .precio(new Money((BigDecimal.valueOf(request.getPrecio()))))
                .stock(request.getStock())
                .status(request.isStatus())
                .marca(marca)
                .categoria(categoria)
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .imagenes(new ArrayList<>())
                .build();


        request.getImagenes().forEach(
                imagenRequest -> {
                    ImagenProducto imagenProducto = ImagenProducto.builder()
                            .url(imagenRequest.getUrl())
                            .productoId(producto.getProductoId())
                            .createdAt(ZonedDateTime.now())
                            .updatedAt(ZonedDateTime.now())
                            .build();
                    producto.getImagenes().add(imagenProducto);

                });

        ProductoEntity productoSaved = productoServiceImplHelper.saveProducto(producto);



        return ProductoMapper.toDomain(productoSaved);
    }

    @Override
    public void eliminarProducto(UUID id) {
        productoServiceImplHelper.deleteById(id);
    }


    private MarcaEntity checkMarca(UUID marcaId) {
        Optional<MarcaEntity> marca = marcaRepository.findById(marcaId);
        if(marca.isEmpty()){
            throw new ProductoDomainException("Marca con id: " + marcaId + " no encontrada");
        }

        return marca.get();
    }

    private CategoriaEntity checkCategoria(UUID categoriaId) {
        Optional<CategoriaEntity> categoria = categoriaRepository.findById(categoriaId);
        if(categoria.isEmpty()){
            throw new ProductoDomainException("Categoria con id: " +  categoriaId + " no encontrada");
        }

        return categoria.get();

    }


}
