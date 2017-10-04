package br.com.unip.hotel.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.unip.hotel.dao.HotelDao;
import br.com.unip.hotel.modelo.Hotel;

@Controller
public class HotelController {

	String dataFormatada;
	String dataFormatada1;
	@RequestMapping("novaBusca")
	public String form() {
		System.out.println("nem entrei aqui");
		return "hotel/index";
	}

	@RequestMapping("selecionaHotel")
	public String buscar(Hotel hotel, Model model) {
		
		// apenas para visualizar no console
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(hotel.getDataEntrada().getTime());
		String dataFormatada1 = new SimpleDateFormat("dd/MM/yyyy").format(hotel.getDataSaida().getTime());

		long millis = hotel.getDataEntrada().getTimeInMillis() - hotel.getDataSaida().getTimeInMillis();
		long segundos = millis / 1000;
		long minutos = segundos / 60;
		long horas = minutos / 60;

		long dias = horas / -24;
		hotel.setQtdDias(dias);

		hotel.setValorTotal(hotel.getQtdDias() * (hotel.getValorDiaria()*hotel.getTipoQuarto()));

		System.out.println("Quantidade de dias " + hotel.getQtdDias());
		System.out.println("Entrada: " + dataFormatada + " Saida: " + dataFormatada1 + " Valor diária: "
				+ hotel.getValorDiaria() + " " + hotel.getTipoQuarto());
		System.out.println(dias * hotel.getValorDiaria());

		HotelDao dao = new HotelDao ();
		dao.adiciona(hotel);
		try{
		dao.adiciona_reservas(hotel);}
		catch(SQLException e ){
			e.printStackTrace();
		}
		
		model.addAttribute("hotel", hotel);
		return "hotel/index";
	}

	
	
}
