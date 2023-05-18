package br.com.loja.virtual.repository.Util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSoure = new ComboPooledDataSource();
		comboPooledDataSoure.setJdbcUrl("jdbc:mysql://localhost:3307/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSoure.setUser("root");
		comboPooledDataSoure.setPassword("Alura123");
		
		this.dataSource = comboPooledDataSoure;
	}
	
	public Connection recuperarConexao() throws SQLException {
		return this.dataSource.getConnection();
		
		
}
}