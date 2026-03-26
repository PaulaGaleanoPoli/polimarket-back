package com.polimarket.controller;

import com.polimarket.model.Producto;
import com.polimarket.model.Venta;
import com.polimarket.repository.ProductoRepository;
import com.polimarket.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PoliMarketController {

    @Autowired private ProductoRepository productoRepo;
    @Autowired private VentaService ventaService;

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
}