package com.polimarket.service;

import com.polimarket.model.DetalleVenta;
import com.polimarket.model.Producto;
import com.polimarket.model.Venta;
import com.polimarket.repository.DetalleVentaRepository;
import com.polimarket.repository.ProductoRepository;
import com.polimarket.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VentaService {

    @Autowired private ProductoRepository productoRepo;
    @Autowired private VentaRepository ventaRepo;
    @Autowired private DetalleVentaRepository detalleRepo;

    public Venta registrarVenta(Long productoId, int cantidad) {

        Producto producto = productoRepo.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no existe"));

        if (producto.getStock() < cantidad) {
            throw new RuntimeException("Stock insuficiente");
        }

        double total = producto.getPrecio() * cantidad;

        Venta venta = new Venta();
        venta.setFecha(String.valueOf(new Date()));
        venta.setTotal(total);

        venta = ventaRepo.save(venta);

        DetalleVenta detalle = new DetalleVenta();
        detalle.setProducto(producto);
        detalle.setCantidad(cantidad);
        detalle.setSubtotal(total);
        detalle.setVenta(venta);

        detalleRepo.save(detalle);

        //Descontamos del stock
        producto.setStock(producto.getStock() - cantidad);
        productoRepo.save(producto);

        return venta;
    }
}