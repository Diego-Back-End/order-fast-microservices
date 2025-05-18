package com.example.Usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Usuario.model.Usuario;
import com.example.Usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repo;

    public Usuario crear(Usuario u) { return repo.save(u); }
    public List<Usuario> listar() { return repo.findAll(); }
    public Usuario modificar(Long id, Usuario u) {
        Usuario existente = repo.findById(id).orElseThrow();
        existente.setNombre(u.getNombre());
        existente.setApellido(u.getApellido());
        existente.setCorreo(u.getCorreo());
        return repo.save(existente);
    }
    public void eliminar(Long id) { repo.deleteById(id); }
}