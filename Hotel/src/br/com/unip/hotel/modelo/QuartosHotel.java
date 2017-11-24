package br.com.unip.hotel.modelo;

public class QuartosHotel {
	private int individual;
	private int duplo;
	private int familia;
	private int multiplo;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIndividual() {
		return individual;
	}

	public void setIndividual(int individual) {
		this.individual = individual;
	}

	public int getDuplo() {
		return duplo;
	}

	public void setDuplo(int duplo) {
		this.duplo = duplo;
	}

	public int getFamilia() {
		return familia;
	}

	public void setFamilia(int familia) {
		this.familia = familia;
	}

	public int getMultiplo() {
		return multiplo;
	}

	public void setMultiplo(int multiplo) {
		this.multiplo = multiplo;
	}

}
