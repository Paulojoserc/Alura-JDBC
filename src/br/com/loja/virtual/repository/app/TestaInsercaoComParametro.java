package br.com.loja.virtual.repository.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.loja.virtual.repository.Util.ConnectionFactory;

public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {
		String nome = "Mouse'";
		String descricao = "Mouse sem fio); delete from Produto;";
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {
			connection.setAutoCommit(false);

			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO ( nome, descricao) VALUES (? , ?)", Statement.RETURN_GENERATED_KEYS)) {
				adicionarVariavel("SmartTv", "45 polegadas", stm);
				adicionarVariavel("Radio", "Radio de bateria", stm);
				connection.commit();

				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}

	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		if (nome.equalsIgnoreCase("Radio")) {

		}
		if (nome.equals("Radio")) {
			throw new RuntimeException("Não foi possivel adicionar o produto");
		}
		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);
			}
			rst.close();
		}
	}
}
