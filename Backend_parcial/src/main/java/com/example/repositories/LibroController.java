package com.example.repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.models.*;
import com.example.controllers.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    private final LibroRepository libroRepository;

    @Autowired
    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @PostMapping
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    @GetMapping
    public List<Libro> obtenerLibros() {
        return libroRepository.findAll();
    }
}
