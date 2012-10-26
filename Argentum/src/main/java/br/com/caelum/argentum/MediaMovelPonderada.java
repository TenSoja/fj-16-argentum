package br.com.caelum.argentum;

import br.com.caelum.argentum.indicadores.Indicador;

public class MediaMovelPonderada implements Indicador{
	
	private final Indicador outroIndicador;
	public MediaMovelPonderada(Indicador outroIndicador) {
		this.outroIndicador = outroIndicador;
		// TODO Auto-generated constructor stub
	}
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		double prod = 1.0;
		for (int i = posicao - 2; i <= posicao; i++) {
			//Candle c = serie.getCandle(i);
			//soma += c.getFechamento()*prod++;
			soma += outroIndicador.calcula(i, serie)*prod++;
		}
		return soma / 6;

	}
	@Override
	public String toString() {
	//return "Média móvel ponderada do fechamento";
		return "Média móvel ponderada do " + outroIndicador;

	}



}
