package com.celyng.ecommerce.controller;


import com.celyng.ecommerce.application.ProductoService;
import com.celyng.ecommerce.application.models.ProductoRequest;
import com.celyng.ecommerce.domain.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ControllerProducto {


    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoRequest request) {
        Producto creado = productoService.crearProducto(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }


    /*
    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoService.obtenerTodos();
    }


    @GetMapping("/{id}")
    public Producto obtenerPorId(@PathVariable Long id) {
        return (Producto) productoService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }



    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody ProductoRequest request) {
        return productoService.actualizarProducto(id, request);
    }


    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
    */
}

