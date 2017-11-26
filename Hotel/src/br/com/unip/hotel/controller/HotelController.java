package br.com.unip.hotel.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.unip.hotel.dao.HotelDao;
import br.com.unip.hotel.modelo.Hotel;

@Controller
public class HotelController {

	String dataFormatada;
	String dataFormatada1;
	@RequestMapping("novaBusca")
	public String novaBusca(Model model) {
		HotelDao dao = new HotelDao();
		model.addAttribute("quartos", dao.verificarQuantidadeQuartoDisponivel());
		return "hotel/index";
	}

	@RequestMapping("selecionaHotel")
	public String buscar(Hotel hotel, Model model, BindingResult result) {
		
		// apenas para visualizar no console
//		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(hotel.getDataEntrada().getTime());
//		String dataFormatada1 = new SimpleDateFormat("dd/MM/yyyy").format(hotel.getDataSaida().getTime());
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
		
		if(dao.verificarLimiteDeReservas(hotel) == false){
		try{
		dao.adiciona_reservas(hotel);}
		catch(SQLException e ){
			e.printStackTrace();
			}
		}else{
			System.out.println("Já existe reserva");
			hotel.setMsg("Não foi possivel reservar este quarto! Limite de reservas excedido!");
			model.addAttribute("hotel", hotel);
			model.addAttribute("quartos", dao.verificarQuantidadeQuartoDisponivel());
			return "hotel/index";
		}
		//------------------------------------------------------------------------------------------------------
		
		model.addAttribute("hotel", hotel);
		
		return "redirect:listaHotel";
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

	@RequestMapping("upload")
	public String upload(HttpServletRequest request){
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("file");
		
		String xml = multipartFile.toString();
		try {
//			File file = new File();
//			file.createNewFile();
//			FileOutputStream out = new FileOutputStream(file);
			
			
			FileReader ler = new FileReader(xml);
			XStream xstream = new XStream(new DomDriver());
			Hotel hotel = (Hotel) xstream.fromXML(ler);
		
			System.out.println(ler );
			System.out.println("Tipo de quarto: "+hotel.getTipoQuarto());
			
		} catch (FileNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(multipartFile.getName());
		return "redirect:upload-success";
	}
		

	
}
