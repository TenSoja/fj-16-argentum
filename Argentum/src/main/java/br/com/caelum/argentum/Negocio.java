package br.com.caelum.argentum;

import java.util.Calendar;

public final class Negocio {
	public final double preco;
	private final int quantidade;
	private final Calendar data;
	
	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar) this.data.clone();
	}

	public Negocio(double preco, int quantidade, Calendar data) {
		if(data == null){
			throw new IllegalArgumentException("data nao pode ser nula");
		}
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}
	
	public double getVolume(){
		return preco * quantidade;
	}

	public boolean isMesmoDia(Calendar outraData) {
		//return this.data.equals(outraData);
		return data.get(Calendar.DATE) == outraData.get(Calendar.DATE);
	}

	public boolean isMesmoAno(Calendar outraData) {
		
		return data.get(Calendar.DATE) == outraData.get(Calendar.DATE) && 
			data.get(Calendar.MONTH) == outraData.get(Calendar.MONTH) &&
			data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR);
	}
}
