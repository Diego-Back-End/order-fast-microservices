package com.example.Restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Restaurante.model.Restaurante;
import com.example.Restaurante.repository.RestauranteRepository;

// RestauranteService
@Service
public class RestauranteService {
    @Autowired
    private RestauranteRepository repo;

    public Restaurante crear(Restaurante r) { return repo.save(r); }
    public List<Restaurante> listar() { return repo.findAll(); }
    public Restaurante modificar(Long id, Restaurante r) {
        Restaurante existente = repo.findById(id).orElseThrow();
        existente.setNombre(r.getNombre());
        existente.setMenu(r.getMenu());
        return repo.save(existente);
    }
    public void eliminar(Long id) { repo.deleteById(id); }
}
