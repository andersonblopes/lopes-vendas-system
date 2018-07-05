package com.lopes.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lopes.vendas.model.Venda;

public interface Vendas extends JpaRepository<Venda, Long> {

}
