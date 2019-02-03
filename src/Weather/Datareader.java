package Weather;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Datareader {
	private BufferedReader bin;
	private String line;
	private String windSpeedS;
	private String cloudCoverageS;
	private String stationNicS;
	private String stationBolS;
	private String stationSurS;
	private String dateS;
	private String timeS;
	private ArrayList<String> windSpeed;
	private ArrayList<String> cloudCoverage;
	private ArrayList<String> stationNic;
	private ArrayList<String> stationBol;
	private ArrayList<String> stationSur;
	private ArrayList<String> date;
	private ArrayList<String> time;
	private static Datareader x;
	
	public Datareader() {
		try {
			bin = new BufferedReader(new FileReader("file.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		stationNic = new ArrayList<String>();
		stationBol = new ArrayList<String>();
		stationSur = new ArrayList<String>();
		date = new ArrayList<String>();
		time = new ArrayList<String>();
		windSpeed = new ArrayList<String>();
		cloudCoverage = new ArrayList<String>();
		stationNicS = "";
		dateS = "";
		timeS = "";
		windSpeedS = "";
		cloudCoverageS = "";


	}
	

	
	public void read() {
		try {
			line = bin.readLine();
			for(int i = 0; i < line.length(); i++) {
				String a;
				if(i != line.length()-1) {
					String b = line.charAt(i+1) + "";

					//System.out.println(line.charAt(i));
					a = line.charAt(i) + "";
					if(a.equals("N") && b.equals("N")) {
						while(true) {
							String c = line.charAt(i+1) + "";
							if(c.equals(">")) {
								stationNic.add(stationNicS);
								stationNicS = "";
								break;
							}
							else {
								stationNicS = stationNicS + c;
								i++;

							}
						}
					}
					if(a.equals("D") && b.equals("N")) {
						while(true) {
							String c = line.charAt(i+1) + "";
							if(c.equals(">")) {
								date.add(dateS);
								dateS = "";
								break;
							}
							else {
								dateS = dateS + c;
								i++;

							}
						}
					}
					if(a.equals("T") && b.equals("N")) {
						while(true) {
							String c = line.charAt(i+1) + "";
							if(c.equals(">")) {
								time.add(timeS);
								timeS = "";
								break;
							
							}
							else {
								timeS = timeS + c;
								i++;

							}
						}
					}

					if(a.equals("W") && b.equals("N")) {
						while(true) {
							String c = line.charAt(i+1) + "";
							if(c.equals(">")) {
								windSpeed.add(windSpeedS);
								windSpeedS = "";
								break;
							
							}
							else {
								windSpeedS = windSpeedS + c;
								i++;

							}
						}
					}
					if(a.equals("C") && b.equals("N")) {
						while(true) {
							String c = line.charAt(i+1) + "";
							if(c.equals(">")) {
								cloudCoverage.add(cloudCoverageS);
								cloudCoverageS = "";
								break;
							}
							else {
								cloudCoverageS = cloudCoverageS + c;
								i++;

							}
						}
					}
					
				}

				
			}
			System.out.println(stationNic.size());
			System.out.println(date.size());
			System.out.println(time.size());
			System.out.println(windSpeed.size());
			System.out.println(cloudCoverage.size());



			

                
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		x = new Datareader();
		x.read();
	}

}
