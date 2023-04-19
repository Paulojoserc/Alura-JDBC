package br.com.loja.virtual.repository.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3307/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "Alura123");
		System.out.println("Fechando conexão!");
		 
		Statement stm = connection.createStatement();
		stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
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
