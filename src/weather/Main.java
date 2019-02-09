package weather;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;


public class Main implements Runnable, ActionListener {
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
	private ClientServer dller;
	private JButton refresh;
	private JButton refresh1;
	private JButton refresh2;
	private Integer i;
	private Integer y;
	
	public Main() {
		//add all the UI components
		dller = new ClientServer();//the connection to the VM server object allows download of the xml file and refresh of graphs
		frame = new JFrame("Weather");
		tabs = new JTabbedPane();
		bar = new BarChart();
		bar.drawChart();
		line = new LineGraph();
		line.drawChart();
		nicLine = new ChartPanel(line.chart);
		nicBar = new ChartPanel(bar.chart);
		refresh = new JButton("Refresh");
		refresh1 = new JButton("Refresh");
		refresh2 = new JButton("Refresh");
		refresh.addActionListener(this);
		refresh1.addActionListener(this);
		refresh2.addActionListener(this);
		nicGraphManager = new JPanel(new GridLayout(2,1));
		nicGraphManager.add(refresh);
		nicGraphManager.add(nicLine);
		nicGraphManager.add(nicBar);
		
		bar1 = new BarChartBol();
		bar1.drawChart();
		line1 = new LineGraphBol();
		line1.drawChart();
		bolLine = new ChartPanel(line1.chart);
		bolBar = new ChartPanel(bar1.chart);
		bolGraphManager = new JPanel(new GridLayout(2,0));
		bolGraphManager.add(refresh1);
		bolGraphManager.add(bolLine);
		bolGraphManager.add(bolBar);
		
		bar2 = new BarChartSur();
		bar2.drawChart();
		line2 = new LineGraphSur();
		line2.drawChart();
		surLine = new ChartPanel(line2.chart);
		surBar = new ChartPanel(bar2.chart);
		surGraphManager = new JPanel(new GridLayout(2,0));
		surGraphManager.add(refresh2);
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
		
	    ImageIcon img = new ImageIcon("./ECAMI.png");//company logo icon.
	    frame.setIconImage(img.getImage());
		
		frame.setVisible(true);
		
		i = 0;//necessary for the remove loop in the updateView method
		y = 0;//necessary for the remove loop in the updateView method
		
	}
	//remove graphs and add them again through
	public void updateView() {
		nicGraphManager.remove(nicBar);
		bolGraphManager.remove(bolBar);
		surGraphManager.remove(surBar);
		nicGraphManager.remove(nicLine);
		bolGraphManager.remove(bolLine);
		surGraphManager.remove(surLine);
		try {
			dller.connect();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BarChart barNN = new BarChart();
		BarChartBol barBN = new BarChartBol();
		BarChartSur barSN = new BarChartSur();
		barNN.drawChart();
		barBN.drawChart();
		barSN.drawChart();
		ChartPanel nicBar = new ChartPanel(barNN.chart);
		ChartPanel bolBar = new ChartPanel(barBN.chart);
		ChartPanel surBar = new ChartPanel(barSN.chart);
		nicGraphManager.add(nicBar);
		bolGraphManager.add(bolBar);
		surGraphManager.add(surBar);
		
		LineGraph lineNN = new LineGraph();
		LineGraphBol lineBN = new LineGraphBol();
		LineGraphSur lineSN = new LineGraphSur();
		lineNN.drawChart();
		lineBN.drawChart();
		lineSN.drawChart();
		ChartPanel nicLine = new ChartPanel(lineNN.chart);
		ChartPanel bolLine = new ChartPanel(lineBN.chart);
		ChartPanel surLine = new ChartPanel(lineSN.chart);
		nicGraphManager.add(nicLine);
		bolGraphManager.add(bolLine);
		surGraphManager.add(surLine);
		
		nicGraphManager.updateUI();
		bolGraphManager.updateUI();
		surGraphManager.updateUI();
		i++;
		if(i>1) {
			nicGraphManager.remove(nicBar);
			bolGraphManager.remove(bolBar);
			surGraphManager.remove(surBar);
			nicGraphManager.remove(nicLine);
			bolGraphManager.remove(bolLine);
			surGraphManager.remove(surLine);
			y++;
			if(y>0) {
				for(int u = 0; u < y; u++) {
					nicGraphManager.remove(nicBar);
					bolGraphManager.remove(bolBar);
					surGraphManager.remove(surBar);
					nicGraphManager.remove(nicLine);
					bolGraphManager.remove(bolLine);
					surGraphManager.remove(surLine);
				}
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		updateView();
	}


	@Override
	public void run() {

	}

}
