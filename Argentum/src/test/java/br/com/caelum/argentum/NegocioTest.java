package br.com.caelum.argentum;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class NegocioTest {

	@Test
	public void dataDoNegocioEhImutavel() {
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		Negocio n = new Negocio(10, 5, c);
		
		n.getData().set(Calendar.DAY_OF_MONTH, 20);
		
		Assert.assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
	
	}
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegocioComDataNula(){
		new Negocio(10, 5, null);
	}
	@Test
	public void mesmoMilissegundoEhDoMesmoDia() {
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();
		
		Negocio negocio = new Negocio(40.0, 100, agora);
		Assert.assertTrue(negocio.isMesmoDia(mesmoMomento));
	}
	@Test
	public void mesmoDiaHorasDiferentesNaoEhDoMesmoDia(){

		Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
		Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);
	
		Negocio negocio = new Negocio(40.0, 100, manha);
		Assert.assertTrue(negocio.isMesmoDia(tarde));
	}
	@Test
	public void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia(){
		
		Calendar dia1 = new GregorianCalendar(2009, 10, 25, 8, 30);
		Calendar dia2 = new GregorianCalendar(2010, 10, 25, 15, 30);
		
		Negocio negocio = new Negocio(40.0, 100, dia1);
		Assert.assertFalse(negocio.isMesmoAno(dia2));
		
	}


}
