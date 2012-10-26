package br.com.caelum.argentum;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candle {
	
	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;
	
	public Candle(double abertura, double fechamento, double minimo,
			double maximo, double volume, Calendar data) {
		if(minimo > maximo){
			throw new IllegalArgumentException("Mínimo não pode ser maior que Máximo.");
		}
		if(data == null){
			throw new IllegalArgumentException("Data não pode ser nula.");
		}
		if(abertura < 0 || fechamento < 0 || minimo < 0 || maximo < 0 || volume < 0){
			throw new IllegalArgumentException("Valores não podem ser negativos.");
		}
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}
	
	public boolean isAlta(){
		return this.abertura < this.fechamento;
	}
	
	public boolean isBaixa(){
		return this.abertura > this.fechamento;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String string = "[Abertura " + this.getAbertura() + ", Fechamento "+ this.getFechamento() + ", Mínima "+ this.getMinimo() + ", Máxima "+ this.getMaximo() +", Volume "+ this.getVolume() +", Data "+ sdf.format(this.getData().getTime())  + "]";
		
		return string;
	}
}
