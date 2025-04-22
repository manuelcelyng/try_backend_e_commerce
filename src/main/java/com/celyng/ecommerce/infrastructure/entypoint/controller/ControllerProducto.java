package com.celyng.ecommerce.infrastructure.entypoint.controller;



import com.celyng.ecommerce.application.port.in.ProductoService;
import com.celyng.ecommerce.infrastructure.entypoint.models.ProductoRequest;
import com.celyng.ecommerce.domain.models.Producto;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@RestController
@RequestMapping("/producto")
public class ControllerProducto {


    private final String BASE_URL = "http://localhost:8080/imagenes/";
    private final Path root = Paths.get("uploads/imagenes");

    @Autowired
    private ProductoService productoService;

    @PostConstruct
    public void init() throws IOException {
        Files.createDirectories(root);
    }


    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoRequest request)  {
        Producto creado = productoService.crearProducto(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }



    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodos() {
        return ResponseEntity.ok(productoService.obtenerTodos());
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok((Producto) productoService.obtenerPorId(id));
    }
    */

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable String id, @RequestBody ProductoRequest request) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, request));
    }


    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable UUID id) {
        productoService.eliminarProducto(id);
    }


    @PostMapping("/upload")
    public ResponseEntity<List<Map<String, String>>> uploadFiles(@RequestParam("files") List<MultipartFile> files){
        List<Map<String, String>> urls = new ArrayList<>(); // array list de las que se retornan

        for (MultipartFile file : files) {
            try {
                String filename =  UUID.randomUUID() + "-" + file.getOriginalFilename();
                Path filePath = root.resolve(filename);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                Map<String,String> urlMap= new HashMap<>();
                urlMap.put("url", BASE_URL +  filename);
                urls.add(urlMap);
            } catch (IOException e){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
        return ResponseEntity.ok(urls);
    }


}

