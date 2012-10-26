package br.com.caelum.argentum.reader;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.thoughtworks.xstream.io.StreamException;

import br.com.caelum.argentum.Negocio;

public class LeitorXMLTest {

	@Test
	public void carregaXmlComUmNegocioEmListaUnitaria() {
	String xmlDeTeste = "<list>"+
						"<negocio>" +
						"<preco>43.5</preco>" +
						"<quantidade>1000</quantidade>" +
						"<data>" +
						"<time>1322233344455</time>" +
						"</data>" +
						"</negocio>" +
						"</list>";
	LeitorXML leitor = new LeitorXML();
	List<Negocio> negocios = leitor.carrega(new StringReader(xmlDeTeste));
	
	Assert.assertEquals(1,negocios.size());
	Assert.assertEquals(43.5,negocios.get(0).getPreco());
	Assert.assertEquals(1000,negocios.get(0).getQuantidade());
	
	}
	@Test
	public void NaoTemNegocio(){
		String xmlDeTeste =  "<list>"+
				"<negocio>" +
				"<preco>43.5</preco>" +
				"<quantidade>1000</quantidade>" +
				"<data>" +
				"<time>1322233344455</time>" +
				"</data>" +
				"</negocio>" +
				"</list>";
		LeitorXML leitor = new LeitorXML();
		List<Negocio> negocios = leitor.carrega(new StringReader(xmlDeTeste));

		Assert.assertEquals(false,negocios.isEmpty());
		
	}
	@Test(expected=StreamException.class)
	public void NaoTemXML(){
		String xmlDeTeste = "";
		LeitorXML leitor = new LeitorXML();
		List<Negocio> negocios = leitor.carrega(new StringReader(xmlDeTeste));

		Assert.assertEquals(false,negocios.isEmpty());
		
	}


}
