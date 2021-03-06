package weather;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Datareader {
	private BufferedReader bin;
	// temp strings needed to store the current value read.
	private String line;
	private String windSpeedS;
	private String cloudCoverageS;
	private String stationNicS;
	private String stationBolS;
	private String stationSurS;
	private String dateS;
	private String timeS;
	// arrays to add all the values
	public ArrayList<String> stationNic;
	public ArrayList<String> stationBol;
	public ArrayList<String> stationSur;
	public ArrayList<String> dateNic;
	public ArrayList<String> timeNic;
	public ArrayList<String> windSpeedNic;
	public ArrayList<String> cloudCoverageNic;
	public ArrayList<String> dateBol;
	public ArrayList<String> timeBol;
	public ArrayList<String> windSpeedBol;
	public ArrayList<String> cloudCoverageBol;
	public ArrayList<String> dateSur;
	public ArrayList<String> timeSur;
	public ArrayList<String> windSpeedSur;
	public ArrayList<String> cloudCoverageSur;

	
	public Datareader() {
		// initializing all the array's and strings
		try {
			bin = new BufferedReader(new FileReader("received.xml"));//file to be read
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		stationNic = new ArrayList<String>();
		stationBol = new ArrayList<String>();
		stationSur = new ArrayList<String>();
		dateNic = new ArrayList<String>();
		timeNic = new ArrayList<String>();
		windSpeedNic = new ArrayList<String>();
		cloudCoverageNic = new ArrayList<String>();
		dateBol = new ArrayList<String>();
		timeBol = new ArrayList<String>();
		windSpeedBol = new ArrayList<String>();
		cloudCoverageBol = new ArrayList<String>();
		dateSur = new ArrayList<String>();
		timeSur = new ArrayList<String>();
		windSpeedSur = new ArrayList<String>();
		cloudCoverageSur = new ArrayList<String>();
		stationNicS = "";
		dateS = "";
		timeS = "";
		windSpeedS = "";
		cloudCoverageS = "";


	}
	

	// TODO optimize the arrays currently the application is very slow when the file is big.
	public void read() {
		// function for reading the file that is written by the weather application
		// the weather application uses a protocol written by Detmer to make it easier to retrieve the values
		// the uncommented part functions almost the exact same as the commented part the only difference is that it checks for different stations
		try {
			line = bin.readLine();
			String f = line.charAt(line.length()-1) + "";
			if(!f.equals(">")) {
				line = line + ">";
			}
			for(int i = (int) (line.length()/1.4); i < line.length(); i++) {
				String a;//needed to look for first character
				if(i != line.length()-1) {
					String b = line.charAt(i+1) + "";//needed for the second character

					//System.out.println(line.charAt(i));
					a = line.charAt(i) + "";
					if(a.equals("N") && b.equals("N")) {//checking if the station number is that of Nicuaraga
						while(true) {
							String c = line.charAt(i+1) + "";
							if(c.equals(">")) { //checking for the end of sequence character to signal that a new value is coming in
								stationNic.add(stationNicS); // adding the station number to the arraylist
								stationNicS = "";//emptying the string
								break;
							}
							else {
								stationNicS = stationNicS + c; //adding the station number character for character to a string
								i++;

							}
						}
					}
					if(a.equals("D") && b.equals("N")) {
						while(true) {
							String c = line.charAt(i+1) + "";
							if(c.equals(">")) {
								dateNic.add(dateS);
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
								timeNic.add(timeS);
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
								windSpeedNic.add(windSpeedS);
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
								cloudCoverageNic.add(cloudCoverageS);
								cloudCoverageS = "";
								break;
							}
							else {
								cloudCoverageS = cloudCoverageS + c;
								i++;

							}
						}
					}
					if(a.equals("B") && b.equals("B")) {
						while(true) {
							String c = line.charAt(i+1) + "";
							if(c.equals(">")) {
								stationBol.add(stationBolS);
								stationNicS = "";
								break;
							}
							else {
								stationNicS = stationNicS + c;
								i++;

							}
						}
					}
					if(a.equals("D") && b.equals("B")) {
						while(true) {
							String c = line.charAt(i+1) + "";
							if(c.equals(">")) {
								dateBol.add(dateS);
								dateS = "";
								break;
							}
							else {
								dateS = dateS + c;
								i++;

							}
						}
					}
					if(a.equals("T") && b.equals("B")) {
						while(true) {
							String c = line.charAt(i+1) + "";
							if(c.equals(">")) {
								timeBol.add(timeS);
								timeS = "";
								break;
							
							}
							else {
								timeS = timeS + c;
								i++;

							}
						}
					}

					if(a.equals("W") && b.equals("B")) {
						while(true) {
							String c = line.charAt(i+1) + "";
							if(c.equals(">")) {
								windSpeedBol.add(windSpeedS);
								windSpeedS = "";
								break;
							
							}
							else {
								windSpeedS = windSpeedS + c;
								i++;

							}
						}
					}
					if(a.equals("C") && b.equals("B")) {
						while(true) {
							String c = line.charAt(i+1) + "";
							if(c.equals(">")) {
								cloudCoverageBol.add(cloudCoverageS);
								cloudCoverageS = "";
								break;
							}
							else {
								cloudCoverageS = cloudCoverageS + c;
								i++;

							}
						}
					}
					if(a.equals("N") && b.equals("S")) {
						while(true) {
							String c = line.charAt(i+1) + "";
							if(c.equals(">")) {
								stationSur.add(stationNicS);
								stationNicS = "";
								break;
							}
							else {
								stationNicS = stationNicS + c;
								i++;

							}
						}
					}
					if(a.equals("D") && b.equals("S")) {
						while(true) {
							String c = line.charAt(i+1) + "";
							if(c.equals(">")) {
								dateSur.add(dateS);
								dateS = "";
								break;
							}
							else {
								dateS = dateS + c;
								i++;

							}
						}
					}
					if(a.equals("T") && b.equals("S")) {
						while(true) {
							String c = line.charAt(i+1) + "";
							if(c.equals(">")) {
								timeSur.add(timeS);
								timeS = "";
								break;
							
							}
							else {
								timeS = timeS + c;
								i++;

							}
						}
					}

					if(a.equals("W") && b.equals("S")) {
						while(true) {
							String c = line.charAt(i+1) + "";
							if(c.equals(">")) {
								windSpeedSur.add(windSpeedS);
								windSpeedS = "";
								break;
							
							}
							else {
								windSpeedS = windSpeedS + c;
								i++;

							}
						}
					}
					if(a.equals("C") && b.equals("S")) {
						while(true) {
							String c = line.charAt(i+1) + "";
							if(c.equals(">")) {
								cloudCoverageSur.add(cloudCoverageS);
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

                
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
