package com.productservice.service;

import com.productservice.model.Producto;

import java.util.List;

// Lo que va a hacer
public interface IProductoService {
    Producto crear(Producto producto);
    Producto actualizar(int id,Producto producto);
    List<Producto> listar();
    Producto obtenerPorId(int id);
    boolean eliminar(int id);

    Producto obtenerPorNombre(String nombre);
}
