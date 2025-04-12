package com.celyng.ecommerce.infrastructure.entypoint.controller;


import com.celyng.ecommerce.application.mapper.CategoriaMapper;
import com.celyng.ecommerce.application.port.in.CategoriaService;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.CategoriaEntity;
import com.celyng.ecommerce.infrastructure.entypoint.models.CategoriaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class ControllerCategoria {

    CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaEntity> crearCategoria(CategoriaRequest request) {
        return ResponseEntity.ok(CategoriaMapper.toEntity(categoriaService.crearCategoria(request)));
    }




}
