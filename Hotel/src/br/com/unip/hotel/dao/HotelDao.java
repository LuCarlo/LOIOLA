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
import br.com.unip.hotel.modelo.QuartosHotel;

public class HotelDao {

	private Connection connection;

	public HotelDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adiciona_reservas(Hotel hotel) throws SQLException {
		String sql = "SELECT id_hotel FROM hotel ";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		int id = rs.getInt("id_hotel");

		rs.close();
		sql = "INSERT INTO reservas (valor_total, dat_entrada, dat_saida, dias_total, id_hotel, tipo_quarto) "
				+ "VALUES (?,?,?,?,?,?) ";
		try {

			stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, hotel.getValorTotal());
			stmt.setDate(2, new java.sql.Date(hotel.getDataEntrada().getTimeInMillis()));
			stmt.setDate(3, new java.sql.Date(hotel.getDataSaida().getTimeInMillis()));
			stmt.setLong(4, hotel.getQtdDias());
			stmt.setInt(5, id);
			stmt.setInt(6, hotel.getTipoQuarto());
			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Hotel> getLista() {
		try {
			List<Hotel> Hoteis = new ArrayList<Hotel>();
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT r.*, hq.valor_diaria, h.nome_hotel, (dias_total * valor_diaria) as val_total FROM reservas r "
							+ "JOIN hotel_quartos hq on r.tipo_quarto = hq.tipo_quarto  "
							+ "INNER JOIN hotel h on h.id_hotel = hq.id_hotel WHERE dat_entrada is not null and dat_saida is not null");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Hotel hotel = new Hotel();
				hotel.setNome(rs.getString("nome_hotel"));
				hotel.setId_hotel(rs.getInt("id_hotel"));
				hotel.setId_reserva(rs.getInt("id_reserva"));
				hotel.setValorDiaria(rs.getDouble("valor_diaria"));
				hotel.setTipoQuarto(rs.getInt("tipo_quarto"));

				// Recuperando data de Entrada
				Calendar dataEntrada = Calendar.getInstance();
				dataEntrada.setTime(rs.getDate("dat_entrada"));
				hotel.setDataEntrada(dataEntrada);

				// Recuperando data de Saida
				Calendar dataSaida = Calendar.getInstance();
				dataSaida.setTime(rs.getDate("dat_saida"));
				hotel.setDataSaida(dataSaida);

				hotel.setValorTotal(rs.getDouble("val_total"));
				hotel.setQtdDias(rs.getLong("dias_total"));

				Hoteis.add(hotel);
			}
			rs.close();
			stmt.close();
			return Hoteis;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Hotel hotel) {
		String sql = "delete from reservas where id_reserva=?";
		// String sqlh = "delete from hotel where id_hotel=?";

		try {
			// PreparedStatement stmth = connection.prepareStatement(sqlh);
			// stmth.setLong(1, hotel.getId_hotel());

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, hotel.getId_reserva());

			// stmth.execute();
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public boolean verificarLimiteDeReservas(Hotel hotel) {
		try {
			String sqlCarlos = "SELECT limite_reserva FROM hotel_quartos WHERE tipo_quarto = ?";
			PreparedStatement stmt = connection.prepareStatement(sqlCarlos);
			stmt.setInt(1, hotel.getTipoQuarto());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int limite = rs.getInt("limite_reserva");
				sqlCarlos = "SELECT COUNT(id_reserva) as quantidade_reservada FROM reservas WHERE tipo_quarto = ?";
				stmt = connection.prepareStatement(sqlCarlos);
				stmt.setInt(1, hotel.getTipoQuarto());
				rs = stmt.executeQuery();
				rs.next();
				int quantidadeReservada = rs.getInt("quantidade_reservada");
				rs.close();
				stmt.close();
				System.out.println("Quantidade reservada: " + quantidadeReservada + " Limite: " + limite);
				if (quantidadeReservada == limite) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return true;
	}

	public QuartosHotel verificarQuantidadeQuartoDisponivel() {
		// List<QuartosHotel> quartos = new ArrayList<QuartosHotel>();
		String sql = "SELECT  hq.tipo_quarto , (limite_reserva - COUNT(hq.tipo_quarto)) disponivel FROM hotel_quartos hq "
				+ "JOIN reservas r on r.tipo_quarto = hq.tipo_quarto "
				+ "GROUP BY hq.limite_reserva, hq.tipo_quarto ORDER BY hq.tipo_quarto";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			QuartosHotel q = new QuartosHotel();
			while (rs.next()) {
				if (rs.getInt("tipo_quarto") == 1) {
					q.setIndividual(rs.getInt("disponivel"));
					q.setNome("Individual");
				} else if (rs.getInt("tipo_quarto") == 2) {
					q.setDuplo(rs.getInt("disponivel"));
					q.setNome("Duplo");
				} else if (rs.getInt("tipo_quarto") == 3) {
					q.setFamilia(rs.getInt("disponivel"));
					q.setNome("Família");
				} else if (rs.getInt("tipo_quarto") == 4) {
					q.setMultiplo(rs.getInt("disponivel"));
					q.setNome("Múltiplo");
				}
			}

			return q;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
