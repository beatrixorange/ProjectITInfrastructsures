package weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection {
	String hostName;
	int portNumber;
	
	public Connection() {
		String hostName = "host";
		int portNumber = 7789;
		
	}
	
	public void connect() {
		try {
			    Socket echoSocket = new Socket(hostName, portNumber);
			    PrintWriter out =
			        new PrintWriter(echoSocket.getOutputStream(), true);
			    BufferedReader in =
			        new BufferedReader(
			            new InputStreamReader(echoSocket.getInputStream()));
			    BufferedReader stdIn =
			        new BufferedReader(
			            new InputStreamReader(System.in));
		    }  catch(IOException e) {
		    	e.printStackTrace();
				
			}
	}

}
