package br.com.loja.virtual.repository.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.loja.virtual.repository.factory.ConnectionFactory;

public class TestaInsercao {
public static void main(String[] args) throws SQLException {
	ConnectionFactory connectionFactory = new ConnectionFactory();
	Connection connection = connectionFactory.recuperarConexao();
	
	Statement stm = connection.createStatement();
	
	stm.execute("INSERT INTO PRODUTO ( nome, descricao) VALUES ('Mouse', 'Mouse sem fio')",Statement.RETURN_GENERATED_KEYS ); 


	ResultSet rst = stm.getGeneratedKeys();
	
	while(rst.next()) {
		Integer id = rst.getInt(1);
		System.out.println("O id criado foi: "+id);
	}
}
}
