package com.lopes.vendas.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lopes.vendas.model.Venda;
import com.lopes.vendas.repository.Produtos;
import com.lopes.vendas.repository.Vendas;

@Service
public class VendaService {

	@Autowired
	private Vendas vendas;

	@Autowired
	private Produtos produtos;

	public Venda adicionar(Venda venda) {
		venda.setCadastro(LocalDateTime.now());
		venda.getItens().forEach(i -> {
			i.setVenda(venda);
			i.setProduto(produtos.findById(i.getProduto().getId()).get());
		});

		BigDecimal totalItens = calculatTotalItens(venda);

		venda.setTotal(totalItens.add(venda.getFrete()));

		return vendas.save(venda);

	}

	private BigDecimal calculatTotalItens(Venda venda) {
		BigDecimal totalItens = venda.getItens().stream()
				.map(i -> i.getProduto().getValor().multiply(new BigDecimal(i.getQuantidade())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		return totalItens;
	}
}
