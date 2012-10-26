package br.com.caelum.argentum;

import java.util.Calendar;

import org.junit.Test;

public class CandlestickTest {

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		new Candle(10, 20, 20, 10, 10000, Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void dataNaoPodeSerNula() {
		new Candle(10, 20, 20, 30, 10000, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nenhumValorPodeSerNegativo() {
		new Candle(-10, 20, 20, 30, 10000, Calendar.getInstance());
	}

}
