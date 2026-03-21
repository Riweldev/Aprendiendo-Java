package com.products.apiproductos;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Producto")
public class ProductoController {

    private final List<Producto> productos = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Producto>> getProductos(){

        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{prodId}")
    public ResponseEntity<Producto> getProductosById(@PathVariable int prodId) {
        return productos.stream()
                .filter(p -> p.getId() == prodId)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Producto> addProducto(@RequestBody Producto prod){
        productos.add(prod);
        return ResponseEntity.created(URI.create("/producto/" + prod.getId())).body(prod);
    }

    @PutMapping("/{prodId}")
    public ResponseEntity<Producto> putProducto(@PathVariable int prodId, @RequestBody Producto prod){
        for (int i=0;i<productos.size();i++){
            if (productos.get(i).getId() == prodId) {
                productos.set(i, prod);
                return ResponseEntity.ok(prod);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{prodId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int prodId){
        boolean eliminado = productos.removeIf(p -> p.getId() == prodId);
        if (eliminado) {
            return ResponseEntity.noContent().build();    // 204 No Content
        }
        return ResponseEntity.notFound().build();
    }
}
