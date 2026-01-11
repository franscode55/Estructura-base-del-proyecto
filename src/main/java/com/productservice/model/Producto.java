package com.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tbl_producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // postgres
    private int Id;
    private String nombreProducto;
    private int cantidad;
    private double precio;
    private String descripcion;
}
