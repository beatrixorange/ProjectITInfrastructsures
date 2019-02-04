package weather;


import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYBarDataset;

public class BarChart extends JPanel {

	public DefaultCategoryDataset dataset;
	public ChartPanel panel;
	public JFreeChart chart;
	public Datareader values;
	private String time;
	private float cloudCoverage;
	

	public BarChart() {
		values = new Datareader();
		chart = ChartFactory.createBarChart(
			"Cloud Coverage in percentages",
			"Time", 
			"Coverage Percentage", 
			createDataset(),
			PlotOrientation.VERTICAL,
			true, true, false);

		
		panel = new ChartPanel(chart);
	    panel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
		
	}
	
	private DefaultCategoryDataset createDataset() {
		
		values.read();
    	final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    for(int i = 0; i < values.stationNic.size(); i = i + 500) {

			time = values.timeNic.get(i);
			time.substring(0,time.length());
			time = time.substring(1,time.length());
			cloudCoverage = Float.parseFloat(values.cloudCoverageNic.get(i).substring(1,values.cloudCoverageNic.get(i).length()));
			dataset.addValue(cloudCoverage,"1", time);
	    }
	    
		return dataset;

	}
		
	


}
