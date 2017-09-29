package br.com.unip.hotel.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() throws SQLException {
		String driver = "org.postgresql.Driver";
		String usuario = "postgres";
		String senha = "juizladrao";
		String url = "jdbc:postgresql://localhost:5432/CotaSmart";

		System.out.println("Conectando...");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
		System.out.println("Conectado");
		return DriverManager.getConnection(url, usuario, senha);
	}
	
	
}
