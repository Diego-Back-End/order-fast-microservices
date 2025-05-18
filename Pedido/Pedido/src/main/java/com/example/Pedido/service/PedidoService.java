package com.example.Pedido.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Pedido.model.Pedido;
import com.example.Pedido.repository.PedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obtenerPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido actualizarPedido(Long id, Pedido actualizado) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setFecha(actualizado.getFecha());
            pedido.setTotal(actualizado.getTotal());
            pedido.setUsuarioId(actualizado.getUsuarioId());
            return pedidoRepository.save(pedido);
        }).orElse(null);
    }

    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }

    public List<Pedido> guardarTodos(List<Pedido> pedidos) {
        return pedidoRepository.saveAll(pedidos);
    }
}