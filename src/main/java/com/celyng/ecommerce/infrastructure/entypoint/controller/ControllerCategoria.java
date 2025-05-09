package com.celyng.ecommerce.infrastructure.entypoint.controller;


import com.celyng.ecommerce.application.mapper.CategoriaMapper;
import com.celyng.ecommerce.application.port.in.CategoriaService;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.CategoriaEntity;
import com.celyng.ecommerce.infrastructure.entypoint.models.CategoriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class ControllerCategoria {


    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaEntity> crearCategoria(@RequestBody CategoriaRequest request) {
        return ResponseEntity.ok(CategoriaMapper.toEntity(categoriaService.crearCategoria(request)));
    }



    @GetMapping
    public ResponseEntity<List<CategoriaEntity>> getAll() {
        return ResponseEntity.ok(categoriaService.getAll());
    }




}
