package Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
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
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	
	
	public LoginPage(){
		loginPage = new JFrame("ECAMI Login Page");
		
		usernameLabel = new JLabel("Username");
		passwordLabel = new JLabel("Password");
		
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		
		loginButton = new JButton("Login");
		gridManager = new JPanel(null);
		
		usernameLabel.setBounds(10, 10, 80, 25);
		gridManager.add(usernameLabel);
		passwordLabel.setBounds(10, 40, 80, 25);
		gridManager.add(passwordLabel);
		usernameField.setBounds(100, 10, 160, 25);
		gridManager.add(usernameField);
		passwordField.setBounds(100, 40, 160, 25);
		gridManager.add(passwordField);
		loginButton.setBounds(10, 80 , 80, 25);
		gridManager.add(loginButton);
		loginPage.add(gridManager);
		
		loginButton.addActionListener(this);
		
	    ImageIcon img = new ImageIcon("./ECAMI.png");
	    loginPage.setIconImage(img.getImage());
	    
		loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loginPage.setSize(300, 150);
		loginPage.setVisible(true);
		
		
	}

	public void actionPerformed(ActionEvent ae) {
		String username = usernameField.getText();
		String password = passwordField.getText();
	    if(username.equals("admin") && password.equals("password")){
	      Main main = new Main();
	      loginPage.setVisible(false);
	    }
	    else{
	      JOptionPane.showMessageDialog(this,"Incorrect login or password",
	      "Error",JOptionPane.ERROR_MESSAGE); 
	    }
	  }
}
