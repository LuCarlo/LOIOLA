package br.com.unip.hotel.modelo;

import java.util.Calendar;

public class Hotel {
	private String nome;
	private String tipoQuarto;
	private double valorDiaria;
	private Calendar dataEntrada;
	private Calendar dataSaida;
	private double valorTotal;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipoQuarto() {
		return tipoQuarto;
	}
	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}
	public double getValorDiario() {
		return valorDiaria;
	}
	public void setValorDiario(double valorDiario) {
		this.valorDiaria = valorDiario;
	}
	public Calendar getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Calendar getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
