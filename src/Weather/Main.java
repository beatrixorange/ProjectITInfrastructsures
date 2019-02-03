package Weather;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.jfree.chart.ChartPanel;


public class Main implements Runnable{
	private JFrame frame;
	private JTabbedPane tabs;
	private BarChart bar;
	private LineGraph line;
	private BarChartBol bar1;
	private LineGraphBol line1;
	private BarChartSur bar2;
	private LineGraphSur line2;
	private ChartPanel nicLine;
	private ChartPanel nicBar;
	private JPanel nicGraphManager;
	private ChartPanel bolLine;
	private ChartPanel bolBar;
	private JPanel bolGraphManager;
	private ChartPanel surLine;
	private ChartPanel surBar;
	private JPanel surGraphManager;
	
	public Main() {
		frame = new JFrame("Weather");
		tabs = new JTabbedPane();
		bar = new BarChart();
		line = new LineGraph();
		nicLine = new ChartPanel(line.chart);
		nicBar = new ChartPanel(bar.chart);
		nicGraphManager = new JPanel(new GridLayout(2,0));
		nicGraphManager.add(nicLine);
		nicGraphManager.add(nicBar);
		
		bar1 = new BarChartBol();
		line1 = new LineGraphBol();
		bolLine = new ChartPanel(line1.chart);
		bolBar = new ChartPanel(bar1.chart);
		bolGraphManager = new JPanel(new GridLayout(2,0));
		bolGraphManager.add(bolLine);
		bolGraphManager.add(bolBar);
		
		bar2 = new BarChartSur();
		line2 = new LineGraphSur();
		surLine = new ChartPanel(line2.chart);
		surBar = new ChartPanel(bar2.chart);
		surGraphManager = new JPanel(new GridLayout(2,0));
		surGraphManager.add(surLine);
		surGraphManager.add(surBar);
		
		frame.setSize(1280, 720);
		frame.setResizable(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(tabs);
		tabs.addTab("Nicaruaga", nicGraphManager);
		tabs.addTab("Bolivia", bolGraphManager );
		tabs.addTab("Suriname", surGraphManager);
		
	    ImageIcon img = new ImageIcon("./ECAMI.png");
	    frame.setIconImage(img.getImage());
		
		frame.setVisible(true);

		
		
	}
	public void updateView() {
		nicGraphManager.updateUI();
		bolGraphManager.updateUI();
		surGraphManager.updateUI();
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			updateView();
		}
	}

}
