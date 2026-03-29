package com.polimarket.controller;

import com.polimarket.model.Producto;
import com.polimarket.model.Venta;
import com.polimarket.repository.ProductoRepository;
import com.polimarket.service.*;
import com.polimarket.service.HistorialService; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PoliMarketController {

    @Autowired private ProductoRepository productoRepo;
    @Autowired private VentaService ventaService;
    @Autowired private HistorialService historialService;

    //Crear producto
    @PostMapping("/productos")
    public Producto crearProducto(@RequestBody Producto p) {
        return productoRepo.save(p);
    }

    //Listar productos
    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return productoRepo.findAll();
    }

    //Registrar venta
    @PostMapping("/venta")
    public Venta vender(
            @RequestParam Long productoId,
            @RequestParam int cantidad) {

        return ventaService.registrarVenta(productoId, cantidad);
    }
    
    // Listar todas las ventas
    @GetMapping("/ventas")
    public List<Venta> listarVentas() {
        return historialService.obtenerTodas();
    }

    // Obtener una venta por ID
    @GetMapping("/ventas/{id}")
    public Venta obtenerVenta(@PathVariable Long id) {
        return historialService.obtenerPorId(id);
    }

}