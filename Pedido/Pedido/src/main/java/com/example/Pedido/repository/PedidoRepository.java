package com.example.Pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Pedido.model.Pedido;

// PedidoRepository
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}