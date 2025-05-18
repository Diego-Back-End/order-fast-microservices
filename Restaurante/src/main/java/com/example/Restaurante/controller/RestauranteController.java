package com.example.Restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Restaurante.model.Restaurante;
import com.example.Restaurante.service.RestauranteService;

// RestauranteController
@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
    @Autowired
    private RestauranteService service;

    @PostMapping
    public Restaurante crear(@RequestBody Restaurante r) {
        return service.crear(r);
    }

    @GetMapping
    public List<Restaurante> listar() { return service.listar(); }

    @PutMapping("/{id}")
    public Restaurante modificar(@PathVariable Long id, @RequestBody Restaurante r) {
        return service.modificar(id, r);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
