package com.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
  private int Id;
    private String nombreProducto;
    private int cantidad;
    private double precio;
    private String descripcion;


}
