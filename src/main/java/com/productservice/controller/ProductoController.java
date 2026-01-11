package com.productservice.controller;

import com.productservice.model.Producto;
import com.productservice.service.IProductoService;
import com.productservice.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/producto") // Esta es la ruta base
@RequiredArgsConstructor
public class ProductoController {
    private final IProductoService productoService;

    @GetMapping
    public List<Producto> getAll() {
        return productoService.listar();
    }

    @GetMapping("/{idProducto}")
    public Producto getById(@PathVariable int idProducto) {
        return productoService.obtenerPorId(idProducto);
    }

    @GetMapping("/{nombreProducto}")
    public Producto getByNombre(@PathVariable String nombreProducto) {
        return productoService.obtenerPorNombre(nombreProducto);
    }

    @PostMapping
    public Producto create(@RequestBody Producto producto) {
        return productoService.crear(producto);
    }

    @PutMapping("/{idProducto}")
    public Producto put(@PathVariable int idProducto,@RequestBody Producto producto) {
        return productoService.actualizar(idProducto, producto);
    }

    @DeleteMapping("/{idProducto}")
    public boolean delete(@PathVariable int idProducto) {
        return productoService.eliminar(idProducto);
    }
}
