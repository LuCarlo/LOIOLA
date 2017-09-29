package br.com.unip.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.unip.hotel.factory.ConnectionFactory;
import br.com.unip.hotel.modelo.Hotel;

public class HotelDao {
	
	private Connection connection;

	public HotelDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adiciona(Hotel hotel) {
		String sql = "INSERT INTO  ("+
					") "+
					"VALUES (?,?,?,?,?,?) ";
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, hotel.getNome());
			stmt.setInt(2, hotel.getTipoQuarto());
			stmt.setDouble(3,hotel.getValorDiaria());
			stmt.setDate(4, null, hotel.getDataEntrada());
			stmt.setDate(5, null, hotel.getDataSaida());
			stmt.setDouble(6, hotel.getValorTotal());
			stmt.setLong(7, hotel.getQtdDias());
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
