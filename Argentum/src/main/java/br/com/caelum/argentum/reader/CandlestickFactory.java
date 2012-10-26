package br.com.caelum.argentum.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

import br.com.caelum.argentum.Candle;
import br.com.caelum.argentum.Negocio;

public class CandlestickFactory {
	public Candle constroiCandleParaData(Calendar data,List<Negocio> negocios){
		
		double maximo = Double.MIN_VALUE;
		double minimo = Double.MAX_VALUE;
		double volume = 0;
		
		if(negocios.isEmpty()){
			minimo = maximo = 0.0;
			
		}else if(negocios.size() == 1){
			minimo = maximo = negocios.get(0).getPreco();
		}
		
		for (Negocio negocio : negocios) {
			volume += negocio.getVolume();
			
			if(negocio.getPreco() > maximo){
				maximo = negocio.getPreco();
			}if (negocio.getPreco() < minimo){
				minimo = negocio.getPreco();
			}
		}
		
		//double abertura = negocios.get(0).getPreco();
		double abertura = negocios.isEmpty() ? 0 : negocios.get(0).getPreco();
		//double fechamento = negocios.get(negocios.size()-1).getPreco();
		double fechamento = negocios.isEmpty() ? 0 : negocios.get(negocios.size() -1).getPreco();
		
	
		
		return new Candle(abertura, fechamento, minimo, maximo, volume, data);
		
	}

	public List<Candle> constroiCandles(List<Negocio> todosNegocios) {
		List<Candle> candles = new ArrayList<Candle>();
		
		List<Negocio> negociosDoDia = new ArrayList<Negocio>();
		Calendar dataAtual = todosNegocios.get(0).getData();
		
		for(Negocio negocio : todosNegocios){
			
			if(!negocio.isMesmoDia(dataAtual)){
				criaEGuardaCandle(candles, negociosDoDia, dataAtual);
				negociosDoDia = new ArrayList<Negocio>();
				dataAtual = negocio.getData();
			}
			negociosDoDia.add(negocio);
		}
		criaEGuardaCandle(candles, negociosDoDia, dataAtual);
		
		return candles;
	}

	private void criaEGuardaCandle(List<Candle> candles,
			List<Negocio> negociosDoDia, Calendar dataAtual) {
		Candle candleDoDia = constroiCandleParaData(dataAtual, negociosDoDia);
		candles.add(candleDoDia);
	}
}
