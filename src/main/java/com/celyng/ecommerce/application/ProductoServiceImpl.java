package com.celyng.ecommerce.application;

import com.celyng.ecommerce.application.mapper.ImagenProductoMapper;
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
import java.util.List;
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

    @Override
    public List<Producto> obtenerTodos() {
        List<ProductoEntity> productoEntities  =  productoServiceImplHelper.obtenerTodos();
        return productoEntities.stream().map(ProductoMapper::toDomain).toList();
    }

    @Override
    public Producto actualizarProducto(String  id, ProductoRequest request) {

        MarcaEntity marca = checkMarca(request.getMarcaId());
        CategoriaEntity categoria = checkCategoria(request.getCategoriaId());

        ProductoEntity existente  = productoServiceImplHelper.findById(id);
        existente.setNombre(request.getNombre());
        existente.setDescripcion(request.getDescripcion());
        existente.setReferencia(request.getReferencia());
        existente.setPrecio(request.getPrecio());
        existente.setStock(request.getStock());
        existente.setStatus(request.isStatus());
        existente.setCategoria(categoria);
        existente.setMarca(marca);


        request.getImagenes().forEach(
                imagenRequest -> {
                    if(existente.getImagenes().stream().noneMatch(imagen -> imagen.getUrl().equals(imagenRequest.getUrl()))){
                        ImagenProducto imagenProducto = ImagenProducto.builder()
                                .url(imagenRequest.getUrl())
                                .productoId(existente.getProductoId())
                                .createdAt(ZonedDateTime.now())
                                .updatedAt(ZonedDateTime.now())
                                .build();
                        existente.getImagenes().add(ImagenProductoMapper.toEntity(imagenProducto));
                    }
                });

        existente.getImagenes().removeIf(
                imagen -> request.getImagenes().stream()
                        .noneMatch(i -> i.getUrl().equals(imagen.getUrl()))
        );

        ProductoEntity productoEntity = productoServiceImplHelper.actualizarProducto(existente);
        return ProductoMapper.toDomain(productoEntity);
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
