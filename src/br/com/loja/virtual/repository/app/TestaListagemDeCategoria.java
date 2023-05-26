package br.com.loja.virtual.repository.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.loja.virtual.repository.Util.ConnectionFactory;
import br.com.loja.virtual.repository.dao.CategoriaDAO;
import br.com.loja.virtual.repository.modelo.Categoria;

public class TestaListagemDeCategoria {
	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoriaDAO.listar();
			listaDeCategorias.stream().forEach(ct ->  System.out.println(ct.getNome()));

		}
	}
}