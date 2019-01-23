package Weather;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineGraph extends JPanel {

	public DefaultCategoryDataset dataset;
	public ChartPanel panel;
	public JFreeChart chart;

	public LineGraph() {
		// Create dataset
		dataset = createDataset();
		// Create chart
		chart = ChartFactory.createLineChart(
			"Average wind speed", // Chart title
			"Day of the week", // X-Axis Label
			"Windspeed", // Y-Axis Label
			dataset
			);

		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		CategoryAxis range = plot.getDomainAxis();
		range.setVisible(false);
		plot.getRenderer().setSeriesPaint(2, Color.orange);
		
		panel = new ChartPanel(chart);
		
	}

	private DefaultCategoryDataset createDataset() {
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		return dataset;
	}

}