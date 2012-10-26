package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.SerieTemporal;

public class MediaMovelSimples implements Indicador {
	
	/* (non-Javadoc)
	 * @see br.com.caelum.argentum.indicadores.Indicador#calcula(int, br.com.caelum.argentum.SerieTemporal)
	 */
	
	private final Indicador outroIndicador;

	public MediaMovelSimples(Indicador outroIndicador) {
		this.outroIndicador = outroIndicador;
		// TODO Auto-generated constructor stub
	}
	
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		for (int i = posicao - 2; i <= posicao; i++) {
			//soma += serie.getCandle(i).getFechamento();
			soma += outroIndicador.calcula(i, serie);

		}
		return soma / 3;

	}

	@Override
	public String toString() {
	//return "Média móvel simples do fechamento";
		return "Média móvel simples do " + outroIndicador;

	}

}
