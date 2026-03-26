package com.polimarket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class DetalleVenta {

    @Id
    @GeneratedValue
    private Long id;

    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Venta venta;
}