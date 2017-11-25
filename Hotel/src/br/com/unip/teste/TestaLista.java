package br.com.unip.teste;



import java.io.FileNotFoundException;
import java.io.FileReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.unip.hotel.modelo.Hotel;

public class TestaLista {

	public static void main(String[] args) {
		
//		HotelDao dao = new HotelDao();
//		XStream xstream = new XStream(new DomDriver()); 
//		xstream.alias("Hotel", Hotel.class);
//		xstream.alias("Hotel", List.class);

		try {
			FileReader ler = new FileReader("C://reserva.xml");
			XStream xstream = new XStream(new DomDriver());
			Hotel hotel = (Hotel) xstream.fromXML(ler);
//			xstream.alias("Hotel", Hotel.class);
			System.out.println("Tipo de quarto: "+hotel.getTipoQuarto() +" DIA ENTRADA: "+ hotel.getDataEntrada()+"DIA SAIDA: "+ hotel.getDataSaida());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		List<Hotel> hoteis = dao.getLista();
//
//		for (Hotel hotel : hoteis) {
//			System.out.println("Nome: " + hotel.getNome());
//			System.out.println("Email: " + hotel.getQtdDias());
//			System.out.println("Endereço: " + hotel.getTipoQuarto());
//			System.out.println("Endereço: " + hotel.getValorDiaria());
//			
//			System.out.println("Data Entrada: " +
//			hotel.getDataEntrada().getTime() + "\n");
//			
//			System.out.println("Endereço: " + hotel.getValorTotal());
//			
//			System.out.println("Data Saida: " +
//			hotel.getDataSaida().getTime() + "\n");
			
//			String xml = xstream.toXML(hotel);
//			System.out.println(xml);
			}
	}
//
//}
