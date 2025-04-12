package com.celyng.ecommerce.infrastructure.entypoint.controller;


import com.celyng.ecommerce.application.mapper.MarcaMapper;
import com.celyng.ecommerce.application.port.in.MarcaService;
import com.celyng.ecommerce.infrastructure.drivenadapter.repository.entity.MarcaEntity;
import com.celyng.ecommerce.infrastructure.entypoint.models.MarcaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marca")
public class ControllerMarca {

    @Autowired
    MarcaService marcaService;

    @PostMapping
    public ResponseEntity<MarcaEntity> crearMarca(@RequestBody MarcaRequest request) {

        return ResponseEntity.ok(MarcaMapper.toEntity(marcaService.crearMarca(request)));

    }

}
