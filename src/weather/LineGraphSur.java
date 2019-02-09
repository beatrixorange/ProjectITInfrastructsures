package weather;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineGraphSur extends JFrame {

	public ChartPanel panel;
	public JFreeChart chart;
	public Datareader values;
	public String time;
	public Float windSpeed;

	public LineGraphSur() {

		
	}

	private DefaultCategoryDataset createDataset() {
		values.read(); // refresh the arrays.
    	final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    	//add the values to the graph
	    for(int i = 0; i < values.stationNic.size(); i = i + 500) {

			time = values.timeSur.get(i);
			time.substring(0,time.length());
			time = time.substring(1,time.length());
			windSpeed = Float.parseFloat(values.windSpeedSur.get(i).substring(1,values.windSpeedSur.get(i).length()));
			dataset.addValue(windSpeed,"1", time);
	    }
	    
		return dataset;

	}
	
	public void drawChart() {
		values = new Datareader();
		chart = ChartFactory.createLineChart(
			"Windspeed", 
			"Time", 
			"Windspeed", 
			createDataset(),
			PlotOrientation.VERTICAL,
			true,true,false		
			);

		
		panel = new ChartPanel(chart);
	    panel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
	}

}
