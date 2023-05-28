package br.com.loja.virtual.repository.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.loja.virtual.repository.dao.ProdutoDAO;
import br.com.loja.virtual.repository.factory.ConnectionFactory;
import br.com.loja.virtual.repository.modelo.Produto;

public class ProdutoController {
	private ProdutoDAO produtoDAO;

	public ProdutoController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.produtoDAO = new ProdutoDAO(connection);
	}

	public void deletar(Integer id) {
		this.produtoDAO.deletar(id);
		System.out.println("Deletando produto");
	}

	public void salvar(Produto produto) {
		this.produtoDAO.salvar(produto);
		System.out.println("Salvando produto");
	}

	public List<Produto> listar() {

		return this.produtoDAO.listar();

	}

	public void alterar(String nome, String descricao, Integer id) {
		this.produtoDAO.alterar(nome, descricao, id);
		System.out.println("Alterando produto");
	}
}
