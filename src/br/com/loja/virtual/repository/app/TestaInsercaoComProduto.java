package br.com.loja.virtual.repository.app;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.loja.virtual.repository.Util.ConnectionFactory;
import br.com.loja.virtual.repository.dao.ProdutoDAO;
import br.com.loja.virtual.repository.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		Produto comoda = new Produto("Cômoda", "Cômoda Vertical");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvar(comoda);
			
		}
		System.out.println(comoda);
	}
}
