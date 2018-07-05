package com.lopes.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lopes.vendas.model.Produto;

public interface Produtos extends JpaRepository<Produto, Long> {

}
