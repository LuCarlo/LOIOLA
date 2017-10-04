package br.com.unip.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.unip.hotel.factory.ConnectionFactory;


public class TestaConexaoBD {

	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().getConnection();
		System.out.println("Conectado");
		con.close();
	}
}
