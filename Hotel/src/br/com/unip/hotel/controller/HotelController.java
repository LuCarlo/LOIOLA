package br.com.unip.hotel.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String buscar(Hotel hotel, Model model, BindingResult result) {
		
		// apenas para visualizar no console
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(hotel.getDataEntrada().getTime());
		String dataFormatada1 = new SimpleDateFormat("dd/MM/yyyy").format(hotel.getDataSaida().getTime());
		//----------------------------------------------------------------------------------------------------
		
		// Calcula a quantidade de dias compreendida na data selecionada na reserva e seta valores no objeto
		long millis = hotel.getDataEntrada().getTimeInMillis() - hotel.getDataSaida().getTimeInMillis();
		long segundos = millis / 1000;
		long minutos = segundos / 60;
		long horas = minutos / 60;

		long dias = horas / -24;
		hotel.setQtdDias(dias);

		hotel.setValorTotal(hotel.getQtdDias() * (hotel.getValorDiaria()*hotel.getTipoQuarto()));
		//----------------------------------------------------------------------------------------------------
		
		// apenas para visualizar no console
		System.out.println("Quantidade de dias " + hotel.getQtdDias());
		System.out.println("Entrada: " + dataFormatada + " Saida: " + dataFormatada1 + " Valor diária: "
				+ hotel.getValorDiaria() + " " + hotel.getTipoQuarto());
		System.out.println(dias * hotel.getValorDiaria());
		//----------------------------------------------------------------------------------------------------
		
		// verifica se o tipo de quarto ja esta reservado, se não, permite a nova reserva e grava dados no banco.
		HotelDao dao = new HotelDao ();
		if(dao.verificaRegistroExistente(hotel) == false){
		dao.adiciona(hotel);
		try{
		dao.adiciona_reservas(hotel);}
		catch(SQLException e ){
			e.printStackTrace();
			}
		}else{
			hotel.setMsg("Não foi possivel reservar este tipo de quarto! Talvez você já tenha reservado em um outro momento"); 
		}
		//------------------------------------------------------------------------------------------------------
		
		model.addAttribute("hotel", hotel);
		
		return "hotel/index";
	}
	
	@RequestMapping("listaHotel")
	public String lista(Model model){
		HotelDao dao = new HotelDao();
		model.addAttribute("hoteis", dao.getLista());
		return "hotel/lista";
		
	}
	
	@RequestMapping("removeHotel")
	public String remove(Hotel hotel) {
	HotelDao dao = new HotelDao();
	dao.remove(hotel);
	return "redirect:listaHotel";
	}

	
	
}
