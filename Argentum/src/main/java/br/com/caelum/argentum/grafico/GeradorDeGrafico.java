package br.com.caelum.argentum.grafico;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import br.com.caelum.argentum.SerieTemporal;
import br.com.caelum.argentum.indicadores.Indicador;

public class GeradorDeGrafico {

	private SerieTemporal serie;
	private int comeco;
	private int fim;
	private DefaultCategoryDataset dados;
	private JFreeChart grafico;

	public GeradorDeGrafico(SerieTemporal serie, int comeco, int fim) {
		this.serie = serie;
		this.comeco = comeco;
		this.fim = fim;
		this.dados = new DefaultCategoryDataset();
		
		this.grafico = ChartFactory.createLineChart("Indicadores", "Dias",
				"Valores", dados, PlotOrientation.VERTICAL, true, true, false);
		this.grafico.setBackgroundPaint(Color.BLACK);
		this.grafico.getCategoryPlot().getDomainAxis().setLabelPaint(Color.WHITE);
		this.grafico.getCategoryPlot().getRangeAxis().setLabelPaint(Color.WHITE);
		this.grafico.getTitle().setPaint(Color.WHITE);
		this.grafico.getCategoryPlot().getDomainAxis().setTickLabelPaint(Color.WHITE);
		this.grafico.getCategoryPlot().getRangeAxis().setTickLabelPaint(Color.WHITE);
		//this.grafico.setBaseItemLabelPaint(Color.WHITE);
	}

	public void plotaIndicador(Indicador ind) {
		for (int i = comeco; i <= fim; i++) {
			double valor = ind.calcula(i, serie);
			dados.addValue(valor, ind.toString(), Integer.valueOf(i));
			}

	}

	public void salva(OutputStream out) throws IOException {
		ChartUtilities.writeChartAsPNG(out, (JFreeChart) grafico, 500, 350);
	}

	public JPanel getPanel() {
		return new ChartPanel(grafico);
	}

}
