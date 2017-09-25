package br.com.unip.hotel.modelo;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Hotel {
	private String nome;
	private int tipoQuarto;
	private double valorDiaria = 150;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataEntrada;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataSaida;
	private double valorTotal;
	private long qtdDias;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTipoQuarto() {
		return tipoQuarto;
	}
	public void setTipoQuarto(int tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}
	public double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
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
	public long getQtdDias() {
		return qtdDias;
	}
	public void setQtdDias(long qtdDias) {
		if(qtdDias == 0){
			qtdDias = 1;
		}
		this.qtdDias = qtdDias;
	}
		
	
}
