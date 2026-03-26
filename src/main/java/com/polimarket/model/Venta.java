package com.polimarket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Venta {

    @Id
    @GeneratedValue
    private Long id;

    private String fecha;
    private double total;
}