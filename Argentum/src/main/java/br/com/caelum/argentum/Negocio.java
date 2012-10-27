package br.com.caelum.argentum;

import java.util.Calendar;

import br.com.caelum.argentum.ui.Coluna;

public final class Negocio {
	public final double preco;
	private final int quantidade;
	private final int volume;
	private final Calendar data;
	
	
	@Coluna(nome="Preço", posicao=0, formato="R$ %,#.2f")
	public double getPreco() {
		return preco;
	}
	@Coluna(nome="Quantidade", posicao=1)
	public int getQuantidade() {
		return quantidade;
	}
	@Coluna(nome="Volume", posicao=2, formato="#.2f")
	public double getVolume(){
		return preco * quantidade;
	}
	@Coluna(nome="Data", posicao=3, formato="%1$td/%1$tm/%1$tY")
	public Calendar getData() {
		return (Calendar) this.data.clone();
	}
	
	public Negocio(double preco, int quantidade, int volume, Calendar data) {
		if(data == null){
			throw new IllegalArgumentException("data nao pode ser nula");
		}
		this.preco = preco;
		this.quantidade = quantidade;
		this.volume = volume;
		this.data = data;
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
