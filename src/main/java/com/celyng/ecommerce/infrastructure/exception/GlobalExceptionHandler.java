package com.celyng.ecommerce.infrastructure.exception;

import com.celyng.ecommerce.domain.exception.ProductoDomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductoDomainException.class)
    public ResponseEntity<Map<String, Object>> handleProductoException(ProductoDomainException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Producto error");
        body.put("message", ex.getMessage());
        body.put("timestamp", ZonedDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
