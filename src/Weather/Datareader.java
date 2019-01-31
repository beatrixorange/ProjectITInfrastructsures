package Weather;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Datareader {
	private BufferedReader bin;
	private String line;
	private String windSpeed;
	private String cloudCoverage;
	private String station;
	private String date;
	private String time;
	
	public Datareader() {
		try {
			bin = new BufferedReader(new FileReader("file.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
    public String split(String s){
    	
        int beginString = -1;
        int endString = -1;
        beginString = s.indexOf(">") + 1;
        endString = s.indexOf("</");
        s = s.substring(beginString,endString);
        return s;      
    }
	
	public void read() {
		try {
			while((line = bin.readLine())!= null) {
                if(line.contains("<NSTN>")) {
                	station = split(line);
                }
                if(line.contains("<BSTN>")) {
                	station = split(line);
                }
                if(line.contains("<SSTN>")) {
                	station = split(line);
                }
                if(line.contains("<DATE>")) {
                	date = split(line);
                }
                if(line.contains("<TIME>")) {
                	time = split(line);
                }
                if(line.contains("<WDSP>")) {
                	windSpeed = split(line);
                }
                if(line.contains("<CLDC>")) {
                	cloudCoverage = split(line);
                }
					
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Datareader x = new Datareader();
		x.read();
		

	}

}
