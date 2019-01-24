package Weather;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginPage extends JFrame implements ActionListener {
	private JFrame loginPage;
	
	private JPanel gridManager;
	private JLabel welcomeLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	
	
	public LoginPage(){
		loginPage = new JFrame("Login Page");
		welcomeLabel = new JLabel("ECAMI Login Page");
		
		usernameLabel = new JLabel("Username");
		passwordLabel = new JLabel("Password");
		
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		
		loginButton = new JButton("Login");
		gridManager = new JPanel(new GridLayout(10,0));
		
		gridManager.add(welcomeLabel);
		gridManager.add(usernameLabel);
		gridManager.add(passwordLabel);
		gridManager.add(usernameField);
		gridManager.add(passwordField);
		gridManager.add(loginButton);
		loginPage.add(gridManager);
		
		loginPage.setSize(1280, 720);
		loginPage.setVisible(true);
		
		
	}

	public void actionPerformed(ActionEvent ae) {
		String username = usernameField.getText();
		char[] password = passwordField.getPassword();
	    if(username.equals("admin") && password.equals("123456")){
	      Main main = new Main();
	    }
	    else{
	      JOptionPane.showMessageDialog(this,"Incorrect login or password",
	      "Error",JOptionPane.ERROR_MESSAGE); 
	    }
	  }
}
