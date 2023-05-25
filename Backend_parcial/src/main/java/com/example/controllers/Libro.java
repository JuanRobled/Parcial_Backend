package com.example.controllers;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "libros_RobledoJ")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String referencia;
    private String autor;
    private Double precio;
    private String ubicacion;

    // Constructor, getters y setters
}
