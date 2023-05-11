package br.com.loja.virtual.repository.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.loja.virtual.repository.Util.ConnectionFactory;

public class TestaRemocao {
public static void main(String[] args) throws SQLException {
	ConnectionFactory factory = new ConnectionFactory();
	Connection connection = factory.recuperarConexao();
	
	PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID >2");
	
	
	Integer linhasModificadas = stm.getUpdateCount();
	
	System.out.println("Quantidade de linhas que foram modificadas: "+linhasModificadas);
}
}
