package br.com.loja.virtual.repository.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.loja.virtual.repository.dao.CategoriaDAO;
import br.com.loja.virtual.repository.factory.ConnectionFactory;
import br.com.loja.virtual.repository.modelo.Categoria;

public class CategoriaController {
	private CategoriaDAO categoriaDAO;
	
	public CategoriaController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.categoriaDAO =  new CategoriaDAO(connection);
	}
	
	public List<Categoria> listar() {
		return this.categoriaDAO.listar();
	}
}
