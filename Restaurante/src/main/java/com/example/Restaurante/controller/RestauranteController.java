package com.example.Restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Restaurante.model.Restaurante;
import com.example.Restaurante.service.RestauranteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public List<Restaurante> obtenerTodos() {
        return restauranteService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Restaurante> obtenerPorId(@PathVariable Long id) {
        return restauranteService.obtenerPorId(id);
    }

    @PostMapping
    public Restaurante crear(@RequestBody Restaurante restaurante) {
        return restauranteService.crear(restaurante);
    }

    @PutMapping("/{id}")
    public Restaurante actualizar(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        return restauranteService.actualizar(id, restaurante);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        restauranteService.eliminar(id);
    }

    @PostMapping("/bulk")
    public List<Restaurante> guardarVarios(@RequestBody List<Restaurante> restaurantes) {
        return restauranteService.guardarTodos(restaurantes);
    }
}