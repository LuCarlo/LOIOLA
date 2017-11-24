package br.com.unip.teste;

import br.com.unip.hotel.modelo.Hotel;

public class TestarDao {

	public static void main(String[] args) {
		
		Hotel h = new Hotel();
		h.setNome("Hotel Erivaldo");
		h.setValorDiaria(150);

//		HotelDao dao = new HotelDao();
//		dao.adiciona(h);
		
		System.out.println("Conectado");


	}

}
