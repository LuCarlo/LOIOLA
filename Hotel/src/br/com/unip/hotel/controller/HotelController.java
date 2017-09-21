package br.com.unip.hotel.controller;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.unip.hotel.modelo.Hotel;

@Controller
public class HotelController {
	
	@RequestMapping("novaBusca")
	public String form(){
		System.out.println("nem entrei aqui");
		return "hotel/index";
	}
	
	@RequestMapping("selecionaHotel")
	public String buscar(Hotel hotel){
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(hotel.getDataEntrada().getTime()); 
		String dataFormatada1 = new SimpleDateFormat("dd/MM/yyyy").format(hotel.getDataSaida().getTime());
		System.out.println("hotel"+dataFormatada +" " + dataFormatada1);
		return "hotel/resultado";
	}
	

}
