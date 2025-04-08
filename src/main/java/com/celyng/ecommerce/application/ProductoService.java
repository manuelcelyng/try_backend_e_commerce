package com.celyng.ecommerce.application;

import com.celyng.ecommerce.application.models.ProductoRequest;
import com.celyng.ecommerce.domain.models.ImagenProducto;
import com.celyng.ecommerce.domain.models.Producto;
import com.celyng.ecommerce.domain.valueObject.Money;
import com.celyng.ecommerce.application.mapper.CategoriaMapper;
import com.celyng.ecommerce.application.mapper.MarcaMapper;
import com.celyng.ecommerce.application.mapper.ProductoMapper;
import com.celyng.ecommerce.repository.CategoriaRepository;
import com.celyng.ecommerce.repository.MarcaRepository;
import com.celyng.ecommerce.repository.ProductoRepository;
import com.celyng.ecommerce.repository.entity.CategoriaEntity;
import com.celyng.ecommerce.repository.entity.MarcaEntity;
import com.celyng.ecommerce.repository.entity.ProductoEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final MarcaRepository marcaRepository;
    private final CategoriaRepository categoriaRepository;

    public Producto crearProducto(ProductoRequest request) {
        MarcaEntity marca = marcaRepository.findById(request.getMarcaId())
                .orElseThrow(() -> new RuntimeException("Marca no encontrada"));
        CategoriaEntity categoria = categoriaRepository.findById(request.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));


        List<ImagenProducto> imagenes = Optional.ofNullable(request.getImagenes()).orElse(List.of()).stream()
                .map(imgReq -> ImagenProducto.builder()
                        .imagenId(UUID.randomUUID())
                        .url(imgReq.getUrl())
                        .createdAt(ZonedDateTime.now())
                        .updatedAt(ZonedDateTime.now())
                        .build())
                .toList();

        Producto producto = Producto.builder()
                .productoId(UUID.randomUUID())
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .referencia(request.getReferencia())
                .precio(new Money((BigDecimal.valueOf(request.getPrecio()))))
                .stock(request.getStock())
                .status(request.isStatus())
                .marca(MarcaMapper.toDomain(marca))
                .categoria(CategoriaMapper.toDomain(categoria))
                .imagenes(imagenes)
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();

        ProductoEntity entity = ProductoMapper.toEntity(producto);
        ProductoEntity saved = productoRepository.save(entity);

        return ProductoMapper.toDomain(saved);
    }


}
