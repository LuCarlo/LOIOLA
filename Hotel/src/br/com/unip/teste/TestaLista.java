package br.com.unip.teste;



import java.util.List;

import br.com.unip.hotel.dao.HotelDao;
import br.com.unip.hotel.modelo.Hotel;

public class TestaLista {

	public static void main(String[] args) {
		
		HotelDao dao = new HotelDao();
		
		List<Hotel> hoteis = dao.getLista();

		for (Hotel hotel : hoteis) {
			System.out.println("Nome: " + hotel.getNome());
			System.out.println("Email: " + hotel.getQtdDias());
			System.out.println("Endereço: " + hotel.getTipoQuarto());
			System.out.println("Endereço: " + hotel.getValorDiaria());
			System.out.println("Endereço: " + hotel.getValorTotal());
//			System.out.println("Data de Nascimento1: " +
//			hotel.getDataEntrada().getTime() + "\n");
//			
//			System.out.println("Data de Nascimento2: " +
//			hotel.getDataSaida().getTime() + "\n");
			}
	}

}
