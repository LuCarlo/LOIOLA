package br.com.unip.hotel.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() throws SQLException {
		String driver = "org.postgresql.Driver";
		String usuario = "postgres";
		String senha = "juizladrao";
		String url = "jdbc:postgresql://localhost:5433/hotel";

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
//Sql banco
//CREATE TABLE public.hotel
//(
//		  id_hotel SERIAL NOT NULL ,
//		  nome_hotel character varying,
//		  CONSTRAINT pk_id_hotel PRIMARY KEY (id_hotel)
//		);
//		INSERT INTO hotel (nome_hotel) VALUES('Hotel Pacheco');
//		CREATE TABLE public.hotel_quartos
//		(
//		  id_hotel_quartos SERIAL NOT NULL ,
//		  id_hotel integer NOT NULL,
//		  tipo_quarto integer,
//		  valor_diaria numeric,
//		  limite_reserva integer,
//		  CONSTRAINT pk_hotel_quartos PRIMARY KEY (id_hotel_quartos),
//		  CONSTRAINT fk_hotel_quartos_hotel FOREIGN KEY (id_hotel)
//		      REFERENCES public.hotel (id_hotel) MATCH SIMPLE
//		      ON UPDATE NO ACTION ON DELETE NO ACTION
//		);
//		INSERT INTO hotel_quartos(id_hotel, tipo_quarto, valor_diaria, limite_reserva) VALUES ( (SELECT id_hotel FROM hotel), 1, 100, 6 );
//		INSERT INTO hotel_quartos(id_hotel, tipo_quarto, valor_diaria, limite_reserva) VALUES ( (SELECT id_hotel FROM hotel), 2, 300, 5 );
//		INSERT INTO hotel_quartos(id_hotel, tipo_quarto, valor_diaria, limite_reserva) VALUES ( (SELECT id_hotel FROM hotel), 3, 400, 4 );
//		INSERT INTO hotel_quartos(id_hotel, tipo_quarto, valor_diaria, limite_reserva) VALUES ( (SELECT id_hotel FROM hotel), 4, 700, 3 );
//		CREATE TABLE public.reservas
//		(
//		  id_reserva SERIAL NOT NULL,
//		  id_hotel integer,
//		  id_hotel_quartos integer,
//		  valor_total numeric,
//		  tipo_quarto integer,
//		  dat_entrada date,
//		  dat_saida date,
//		  dias_total integer,
//		  CONSTRAINT pk_id_reserva PRIMARY KEY (id_reserva),
//		  CONSTRAINT fk_reserva_hotel FOREIGN KEY (id_hotel)
//		      REFERENCES public.hotel (id_hotel) MATCH SIMPLE
//		      ON UPDATE NO ACTION ON DELETE NO ACTION,
//		  CONSTRAINT fk_reserva_hotel_quartos FOREIGN KEY (id_hotel_quartos)
//		      REFERENCES public.hotel_quartos (id_hotel_quartos) MATCH SIMPLE
//		      ON UPDATE NO ACTION ON DELETE NO ACTION
//		);
//		INSERT INTO reservas  (id_hotel, tipo_quarto) VALUES ( (SELECT id_hotel FROM hotel), 1);
//		INSERT INTO reservas  (id_hotel, tipo_quarto) VALUES ( (SELECT id_hotel FROM hotel), 2);
//		INSERT INTO reservas  (id_hotel, tipo_quarto) VALUES ( (SELECT id_hotel FROM hotel), 3);
//		INSERT INTO reservas  (id_hotel, tipo_quarto) VALUES ( (SELECT id_hotel FROM hotel), 4);
