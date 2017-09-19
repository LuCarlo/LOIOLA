package br.com.unip.hotel.controller;

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
		System.out.println(hotel.getTipoQuarto());
		return "hotel/resultado";
	}

}
