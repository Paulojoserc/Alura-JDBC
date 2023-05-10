package br.com.loja.virtual.repository.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.loja.virtual.repository.Util.ConnectionFactory;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		System.out.println("Fechando conexão!");

		PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		

		ResultSet rst = stm.getResultSet();

		while (rst.next()) {
			Integer id = rst.getInt("ID");
			System.out.println(id);

			String nome = rst.getString("Nome");
			System.out.println(nome);

			String descricao = rst.getString("DESCRICAO");
			System.out.println(descricao);
		}
		System.out.println("Resultado");
		connection.close();
	}
}
