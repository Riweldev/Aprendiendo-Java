package com.products.apiproductos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Producto")
public class ProductoController {

    public List<Producto> productos = new ArrayList<>();

    @GetMapping
    public List<Producto> getProductos(){
        return productos;
    }

    @PostMapping
    public Producto addProducto(@RequestBody Producto prod){
        productos.add(prod);
        return prod;
    }
}
