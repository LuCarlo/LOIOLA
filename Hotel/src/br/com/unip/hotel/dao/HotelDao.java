package br.com.unip.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.unip.hotel.factory.ConnectionFactory;
import br.com.unip.hotel.modelo.Hotel;

public class HotelDao {
	
	private Connection connection;
	int id;
	
	public HotelDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adiciona(Hotel hotel) {
		String sql = "INSERT INTO hotel (" + "nome, val_diaria) "
				+ "VALUES (?,?) ";
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, hotel.getNome());
			stmt.setDouble(2,hotel.getValorDiaria());
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adiciona_reservas(Hotel hotel) throws SQLException {
		
		String sql1 = "select id_hotel from hotel where nome=?";
		PreparedStatement stmt1 = connection.prepareStatement(sql1);
		stmt1.setString(1, hotel.getNome());
		ResultSet rs = stmt1.executeQuery();
		
		while(rs.next()){
			 id = rs.getInt("id_hotel");
		}

		rs.close();

		String sql = "INSERT INTO reservas (" + " val_total, dat_entrada, dat_saida, dias_total,id_hotel) "
				+ "VALUES (?,?,?,?,?) ";
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, hotel.getValorTotal());
			stmt.setDate(2, new java.sql.Date(
					hotel.getDataEntrada().getTimeInMillis()));
			stmt.setDate(3, new java.sql.Date(
					hotel.getDataSaida().getTimeInMillis()));
			stmt.setLong(4,hotel.getQtdDias());
			stmt.setInt(5, id);
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Hotel> getLista() {
		try {
			List<Hotel> Hoteis = new ArrayList<Hotel>();
			PreparedStatement stmt = connection.prepareStatement("select * from hotel");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Hotel hotel = new Hotel();
				hotel.setNome(rs.getString("nome"));
				hotel.setValorDiaria(rs.getDouble("valor_diaria"));
				Hoteis.add(hotel);
			}
			rs.close();
			stmt.close();
			return Hoteis;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Hotel> getListaReservas() {
		try {
			List<Hotel> Hoteis = new ArrayList<Hotel>();
			PreparedStatement stmt = connection.prepareStatement("select * from reservas");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Hotel hotel = new Hotel();
				hotel.setValorTotal(rs.getDouble("val_total"));

				Calendar data = hotel.getDataEntrada().getTimeInMillis();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				Hoteis.add(hotel);
			}
			rs.close();
			stmt.close();
			return Hoteis;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
}
