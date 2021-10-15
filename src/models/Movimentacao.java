package models;

import java.util.Date;

public class Movimentacao {
	
	private int id;
	private String modelo;
	private String placa;
	private String dateEntrada = new Date().toString();
	private String dateSaida;
	private int tempo;
	private double valor_pago;
	
	public Movimentacao() {}
	
	public Movimentacao(String modelo, String placa, String dateSaida, int tempo, double valor_pago) {
		super();
		this.modelo = modelo;
		this.placa = placa;
		this.dateSaida = dateSaida;
		this.tempo = tempo;
		this.valor_pago = valor_pago;
	}
	
	
	
	public int getTempo() {
		return tempo;
	}



	public void setTempo(int tempo) {
		this.tempo = tempo;
	}



	public double getValor_pago() {
		return valor_pago;
	}



	public void setValor_pago(double valor_pago) {
		this.valor_pago = valor_pago;
	}



	public void setDateEntrada(String dateEntrada) {
		this.dateEntrada = dateEntrada;
	}



	public String getDateEntrada() {
		return dateEntrada;
	}




	public String getDateSaida() {
		return dateSaida;
	}


	public void setDateSaida(String dateSaida) {
		this.dateSaida = dateSaida;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	

}
