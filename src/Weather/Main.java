package Weather;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.jfree.chart.ChartPanel;


public class Main {
	private JFrame frame;
	private JTabbedPane tabs;
	private BarChart bar;
	private LineGraph line;
	private ChartPanel panel;
	private ChartPanel panel2;
	private JPanel graphManager;
	
	public Main() {
		frame = new JFrame("Weather");
		tabs = new JTabbedPane();
		bar = new BarChart();
		line = new LineGraph();
		panel = new ChartPanel(line.chart);
		panel2 = new ChartPanel(bar.chart);
		graphManager = new JPanel(new GridLayout(2,0));
		graphManager.add(panel2);
		graphManager.add(panel);
		
		frame.setSize(1280, 720);
		frame.setResizable(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(tabs);
		tabs.addTab("Nicaruaga", graphManager);
		tabs.addTab("Bolivia", null );
		tabs.addTab("Suriname", null);
		frame.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginPage();

	}

}
