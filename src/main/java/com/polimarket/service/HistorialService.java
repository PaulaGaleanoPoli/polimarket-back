package com.polimarket.service;

import com.polimarket.model.Venta;
import com.polimarket.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HistorialService {

    @Autowired
    private VentaRepository ventaRepo;

    // Retorna todas las ventas registradas
    public List<Venta> obtenerTodas() {
        return ventaRepo.findAll();
    }

    // Retorna una venta específica por su ID
    public Venta obtenerPorId(Long id) {
        return ventaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con id: " + id));
    }
}