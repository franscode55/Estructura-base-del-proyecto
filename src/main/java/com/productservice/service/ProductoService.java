package com.productservice.service;

import com.productservice.model.Producto;
import com.productservice.repository.IProductoRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
// Como lo va a hacer
public class ProductoService implements IProductoService {

    // "final" -> Inmutabilidad : Inyeccion de dependencia ( private readonly )
    // Si es inmutable , necesito un valor inicial ( Y ese valor no va a cambiar)
    // Inyectas instancias -> Asociadas a una clase
    private final IProductoRepository  productoRepository;


    @Override
    public Producto crear(Producto producto) {
        return productoRepository.save(producto); // Ingreso a la bd
    }

    // Yo cuando actualizo mando un ID
    @Override
    public Producto actualizar(int id, Producto producto) {

        if(productoRepository.findById(id).isEmpty()){
            throw new RuntimeException("El id enviado ,no esta asociado a ningun producto");
        }

        //productoRepository.findById(id).orElseThrow(() -> new RuntimeException("no existe el id"));

        producto.setId(id);
        return productoRepository.save(producto); // Actualizar la bd
    }

    @Override
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerPorId(int id) {
        return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("El id de producto no existe"));
    }

    @Override
    public boolean eliminar(int id) {

        Producto productoEncontrado = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("El id de producto no existe"));

        if(!productoEncontrado.getNombreProducto().isEmpty()){
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Producto obtenerPorNombre(String nombre) {
        return productoRepository.findByNombreProducto(nombre);
    }
}
