package Weather;


import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart extends JPanel {

	public DefaultCategoryDataset dataset;
	public ChartPanel panel;
	public JFreeChart chart;
	public Datareader values;

	public BarChart() {
		values = new Datareader();
		chart = ChartFactory.createBarChart(
			"Cloud Coverage in percentages",
			"Day of the week", 
			"Coverage Percentage", 
			createDataset(),
			PlotOrientation.VERTICAL,
			true, true, false);

		
		panel = new ChartPanel(chart);
	    panel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
	    values.read();
		
	}
	
	private CategoryDataset createDataset() {
		final String monday = "Monday";
		final String tuesday = "Tuesday";
		final String wednesday = "Wednesday";
		final String thursday = "Thursday";
		final String friday = "Friday";
		final String saturday = "Saturday";
		final String sunday = "Sunday";
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		dataset.addValue(85, monday, monday);
		dataset.addValue(65, tuesday, tuesday);
		dataset.addValue(35, wednesday, wednesday);
		dataset.addValue(67, thursday, thursday);
		dataset.addValue(100, friday, friday);
		dataset.addValue(15, saturday, saturday);
		dataset.addValue(20, sunday, sunday);
		
		return dataset;
	}


}
