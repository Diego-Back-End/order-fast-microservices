package com.example.Restaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Restaurante.model.Restaurante;
import com.example.Restaurante.repository.RestauranteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<Restaurante> obtenerTodos() {
        return restauranteRepository.findAll();
    }

    public Optional<Restaurante> obtenerPorId(Long id) {
        return restauranteRepository.findById(id);
    }

    public Restaurante crear(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    public Restaurante actualizar(Long id, Restaurante actualizado) {
        return restauranteRepository.findById(id).map(restaurante -> {
            restaurante.setNombre(actualizado.getNombre());
            restaurante.setDireccion(actualizado.getDireccion());
            restaurante.setTelefono(actualizado.getTelefono());
            return restauranteRepository.save(restaurante);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        restauranteRepository.deleteById(id);
    }
    public List<Restaurante> guardarTodos(List<Restaurante> restaurantes) {
        return restauranteRepository.saveAll(restaurantes);
    }
}