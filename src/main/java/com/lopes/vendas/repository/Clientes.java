package com.lopes.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lopes.vendas.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long> {

}
