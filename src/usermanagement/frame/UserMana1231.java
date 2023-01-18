package usermanagement.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.JsonObject;

import usermanagement.service.UserService;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

public class UserMana1231 extends JFrame {

	private CardLayout mainCard;
	private JPanel mainPanel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField registerUsernameField;
	private JPasswordField registerPasswordField;
	private JTextField registerNameField;
	private JTextField registerEmailField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMana1231 frame = new UserMana1231();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserMana1231() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500 );
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBorder(null);

		setContentPane(mainPanel);
		mainCard = new CardLayout();
		mainPanel.setLayout(mainCard);
		
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(new Color(255, 255, 255));
		
		mainPanel.add(loginPanel, "loginPanel");
		loginPanel.setLayout(null);
		
		JLabel logoText = new JLabel("User Management");
		logoText.setFont(new Font("CookieRun Black", Font.BOLD, 20));
		logoText.setHorizontalAlignment(SwingConstants.CENTER);
		logoText.setBounds(50, 10, 298, 69);
		loginPanel.add(logoText);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("CookieRun Black", Font.BOLD, 18));
		lblNewLabel.setBounds(141, 62, 104, 37);
		loginPanel.add(lblNewLabel);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("CookieRun Black", Font.PLAIN, 12));
		usernameField.setBounds(50, 188, 298, 23);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("CookieRun Black", Font.PLAIN, 12));
		passwordField.setBounds(50, 270, 298, 23);
		loginPanel.add(passwordField);
		
		JLabel Password = new JLabel("Username or Email");
		Password.setFont(new Font("CookieRun Black", Font.BOLD, 12));
		Password.setHorizontalAlignment(SwingConstants.LEFT);
		Password.setBounds(50, 161, 147, 17);
		loginPanel.add(Password);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("CookieRun Black", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(50, 238, 147, 22);
		loginPanel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("CookieRun Black", Font.BOLD, 20));
		btnNewButton.setBounds(50, 328, 298, 50);
		loginPanel.add(btnNewButton);
		
		JLabel signup = new JLabel("Don't have an account?");
		signup.setFont(new Font("CookieRun Black", Font.BOLD, 14));
		signup.setHorizontalAlignment(SwingConstants.LEFT);
		signup.setBounds(50, 388, 231, 23);
		loginPanel.add(signup);
		
		JLabel lblNewLabel_4 = new JLabel("Sign-up");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "registerPanel");
			}
		});//익명클래스
		lblNewLabel_4.setForeground(new Color(0, 128, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("CookieRun Black", Font.BOLD, 14));
		lblNewLabel_4.setBounds(260, 388, 88, 23);
		loginPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Forgot your password?");
		lblNewLabel_5.setForeground(new Color(0, 128, 255));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("CookieRun Black", Font.BOLD, 14));
		lblNewLabel_5.setBounds(50, 421, 298, 23);
		loginPanel.add(lblNewLabel_5);
		
		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(registerPanel, "registerPanel");
		registerPanel.setLayout(null);
		
		JLabel signinLink = new JLabel("Sign in");
		signinLink.setBackground(new Color(0, 0, 0));
		signinLink.addMouseListener(new MouseAdapter() { //어댑터 패턴
			
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "loginPanel");
			}
		});
		signinLink.setFont(new Font("CookieRun Black", Font.PLAIN, 18));
		signinLink.setHorizontalAlignment(SwingConstants.CENTER);
		signinLink.setBounds(248, 421, 99, 17);
		registerPanel.add(signinLink);
		
		JLabel registerLogoText = new JLabel("User Management");
		registerLogoText.setFont(new Font("CookieRun Black", Font.BOLD, 20));
		registerLogoText.setHorizontalAlignment(SwingConstants.CENTER);
		registerLogoText.setBounds(49, 10, 298, 69);
		registerPanel.add(registerLogoText);
		
		JLabel registerText = new JLabel("REGISTER");
		registerText.setHorizontalAlignment(SwingConstants.CENTER);
		registerText.setFont(new Font("CookieRun Black", Font.BOLD, 18));
		registerText.setBounds(141, 62, 104, 37);
		registerPanel.add(registerText);
		
		JLabel registerusernameLabel = new JLabel("Username or Email");
		registerusernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerusernameLabel.setFont(new Font("CookieRun Black", Font.BOLD, 12));
		registerusernameLabel.setBounds(38, 119, 147, 17);
		registerPanel.add(registerusernameLabel);
		
		JLabel registerpasswordLabel = new JLabel("Password");
		registerpasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerpasswordLabel.setFont(new Font("CookieRun Black", Font.BOLD, 12));
		registerpasswordLabel.setBounds(38, 172, 147, 22);
		registerPanel.add(registerpasswordLabel);
		
		JLabel registernameLabel = new JLabel("name");
		registernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registernameLabel.setFont(new Font("CookieRun Black", Font.BOLD, 12));
		registernameLabel.setBounds(38, 241, 147, 22);
		registerPanel.add(registernameLabel);
		
		JLabel registeremailLabel = new JLabel("email");
		registeremailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registeremailLabel.setFont(new Font("CookieRun Black", Font.BOLD, 12));
		registeremailLabel.setBounds(38, 306, 147, 22);
		registerPanel.add(registeremailLabel);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("CookieRun Black", Font.PLAIN, 12));
		usernameField.setColumns(10);
		usernameField.setBounds(49, 139, 298, 23);
		registerPanel.add(usernameField);
		
		registerPasswordField = new JPasswordField();
		registerPasswordField.setFont(new Font("CookieRun Black", Font.PLAIN, 12));
		registerPasswordField.setBounds(49, 208, 298, 23);
		registerPanel.add(registerPasswordField);
		
		nameField = new JTextField();
		nameField.setFont(new Font("CookieRun Black", Font.PLAIN, 12));
		nameField.setColumns(10);
		nameField.setBounds(49, 273, 298, 23);
		registerPanel.add(nameField);
		
		emailField = new JTextField();
		emailField.setFont(new Font("CookieRun Black", Font.PLAIN, 12));
		emailField.setColumns(10);
		emailField.setBounds(49, 337, 298, 23);
		registerPanel.add(emailField);
		
		JLabel lblNewLabel_1 = new JLabel("REGISTER");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				JsonObject userJson = new JsonObject();
				userJson.addProperty( "username", registerUsernameField.getText());
				userJson.addProperty( "password", registerPasswordField.getText());
				userJson.addProperty( "name", registerNameField.getText());
				userJson.addProperty( "email", registerEmailField.getText());
				
				
				UserService userService = UserService.getInstance();
				
				Map<String, String> response = userService.register(userJson.toString());
				
				if(response.containsKey("error")) {
					//키값안에 들어있는지 확인해줌
					JOptionPane.showMessageDialog(null, response.get("error"), "error", JOptionPane.ERROR_MESSAGE);
					return;  //이벤트에 대한 리턴
				}
				
				
				//userService.register(userJson.toString());
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("CookieRun Black", Font.BOLD, 18));
		lblNewLabel_1.setBounds(93, 370, 206, 37);
		registerPanel.add(lblNewLabel_1);
	}
}
