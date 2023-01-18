package usermanagement.frame; //테스팅은 최대한 많이 끝까지해볼것

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.google.gson.JsonObject;

import usermanagement.service.UserService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserManagementFrame extends JFrame {
	
	private List<JTextField> loginFields;
	private List<JTextField> registerFields;

	private CardLayout mainCard;
	private JPanel mainPanel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField registerUsernameField;
	private JPasswordField registerPasswordField;
	private JTextField registerNameField;
	private JTextField registerEmailField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagementFrame frame = new UserManagementFrame();  //생성자 호출
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UserManagementFrame() {
		loginFields = new ArrayList<>();
		registerFields = new ArrayList<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
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

		JLabel logoText = new JLabel("UserManagement");
		logoText.setFont(new Font("CookieRun Regular", Font.BOLD, 20));
		logoText.setHorizontalAlignment(SwingConstants.CENTER);
		logoText.setBounds(86, 34, 213, 56);
		loginPanel.add(logoText);

		JLabel loginText = new JLabel("Login");
		loginText.setFont(new Font("Gadugi", Font.PLAIN, 30));
		loginText.setHorizontalAlignment(SwingConstants.CENTER);
		loginText.setBounds(121, 69, 135, 56);
		loginPanel.add(loginText);

		usernameField = new JTextField();
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setBounds(37, 210, 311, 26);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(37, 261, 311, 26);
		loginPanel.add(passwordField);

		JLabel usernameLabel = new JLabel("Username or email");
		usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		usernameLabel.setFont(new Font("CookieRun Regular", Font.PLAIN, 12));
		usernameLabel.setBounds(37, 194, 144, 15);
		loginPanel.add(usernameLabel);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLabel.setFont(new Font("CookieRun Regular", Font.PLAIN, 12));
		passwordLabel.setBounds(37, 246, 144, 15);
		loginPanel.add(passwordLabel);

		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JsonObject loginUser = new JsonObject();
				loginUser.addProperty("usernameAndEmail", usernameField.getText());
				loginUser.addProperty("password", passwordField.getText());
				
				UserService userService = UserService.getInstance();
				
				Map<String, String> response = userService.authorize(loginUser.toString());
				
				if(response.containsKey("ok")) {
					JOptionPane.showMessageDialog(null, response.get("error"), "error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				JOptionPane.showMessageDialog(null, response.get("ok"), "ok", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
//		MouseListener listener = new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				super.mouseClicked(e);
//			
//		};
//		
//		loginButton.addMouseListener(listener);
//		
		loginButton.addMouseListener(new MouseAdapter() {  //마우스어댑터가 리스너를 이미 구현함 마우스 어댑터로 구현하고싶은것만 구현
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		loginButton.setForeground(new Color(0, 0, 0));
		loginButton.setFont(new Font("CookieRun Black", Font.BOLD, 15));
		loginButton.setBackground(new Color(255, 255, 255));
		loginButton.setBounds(37, 311, 311, 36);
		loginPanel.add(loginButton);

		JLabel signupDesc = new JLabel("Don't have an account?");
		signupDesc.setFont(new Font("CookieRun Regular", Font.PLAIN, 12));
		signupDesc.setBounds(79, 374, 154, 26);
		loginPanel.add(signupDesc);

		JLabel signupLink = new JLabel("Sign up");
		signupLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "registerPanel");
				clearFields(loginFields);
			}
		});
		signupLink.setForeground(new Color(0, 102, 204));
		signupLink.setFont(new Font("CookieRun Regular", Font.PLAIN, 12));
		signupLink.setBounds(242, 380, 57, 15);
		loginPanel.add(signupLink);

		JLabel forgotPasswordLink = new JLabel("Forgot your password?");
		forgotPasswordLink.setForeground(new Color(0, 102, 204));
		forgotPasswordLink.setFont(new Font("CookieRun Regular", Font.PLAIN, 12));
		forgotPasswordLink.setBounds(110, 394, 154, 26);
		loginPanel.add(forgotPasswordLink);

		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(registerPanel, "registerPanel");
		registerPanel.setLayout(null);

		JLabel signinLink = new JLabel("Sign in");
		signinLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "loginPanel");
				clearFields(registerFields);
			}
		});
		signinLink.setForeground(new Color(0, 102, 153));
		signinLink.setHorizontalAlignment(SwingConstants.CENTER);
		signinLink.setBounds(236, 408, 111, 24);
		registerPanel.add(signinLink);

		JLabel registerLogoText = new JLabel("UserManagement");
		registerLogoText.setHorizontalAlignment(SwingConstants.CENTER);
		registerLogoText.setFont(new Font("CookieRun Regular", Font.BOLD, 20));
		registerLogoText.setBounds(86, 34, 213, 56);
		registerPanel.add(registerLogoText);

		JLabel registerText = new JLabel("Register");
		registerText.setHorizontalAlignment(SwingConstants.CENTER);
		registerText.setFont(new Font("Gadugi", Font.PLAIN, 30));
		registerText.setBounds(121, 69, 135, 56);
		registerPanel.add(registerText);

		JLabel registerUsernameLabel = new JLabel("Username");
		registerUsernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerUsernameLabel.setFont(new Font("CookieRun Regular", Font.PLAIN, 12));
		registerUsernameLabel.setBounds(36, 135, 144, 15);
		registerPanel.add(registerUsernameLabel);

		registerUsernameField = new JTextField();
		registerUsernameField.setHorizontalAlignment(SwingConstants.CENTER);
		registerUsernameField.setColumns(10);
		registerUsernameField.setBounds(36, 151, 311, 26);
		registerPanel.add(registerUsernameField);

		JLabel registerPasswordLabel = new JLabel("Password");
		registerPasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerPasswordLabel.setFont(new Font("CookieRun Regular", Font.PLAIN, 12));
		registerPasswordLabel.setBounds(36, 187, 144, 15);
		registerPanel.add(registerPasswordLabel);

		registerPasswordField = new JPasswordField();
		registerPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
		registerPasswordField.setBounds(36, 202, 311, 26);
		registerPanel.add(registerPasswordField);

		JLabel registerNameLabel = new JLabel("name");
		registerNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerNameLabel.setFont(new Font("CookieRun Regular", Font.PLAIN, 12));
		registerNameLabel.setBounds(36, 238, 144, 15);
		registerPanel.add(registerNameLabel);

		registerNameField = new JTextField();
		registerNameField.setHorizontalAlignment(SwingConstants.CENTER);
		registerNameField.setColumns(10);
		registerNameField.setBounds(36, 254, 311, 26);
		registerPanel.add(registerNameField);

		JLabel registerEmailLabel = new JLabel("email");
		registerEmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerEmailLabel.setFont(new Font("CookieRun Regular", Font.PLAIN, 12));
		registerEmailLabel.setBounds(36, 290, 144, 15);
		registerPanel.add(registerEmailLabel);

		registerEmailField = new JTextField();
		registerEmailField.setHorizontalAlignment(SwingConstants.CENTER);
		registerEmailField.setColumns(10);
		registerEmailField.setBounds(36, 306, 311, 26);
		registerPanel.add(registerEmailField);


		JButton lblNewLabel_1 = new JButton("REGISTER");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {  //정의만 한것 
				JsonObject userJson = new JsonObject();
				userJson.addProperty("username", registerUsernameField.getText());
				userJson.addProperty("password", registerPasswordField.getText());
				userJson.addProperty("name", registerNameField.getText());
				userJson.addProperty("email", registerEmailField.getText());

				UserService userService = UserService.getInstance();

				Map<String, String> response = userService.register(userJson.toString());

				if (response.containsKey("error")) {
					// 키값안에 들어있는지 확인해줌
					JOptionPane.showMessageDialog(null, response.get("error"), "error", JOptionPane.ERROR_MESSAGE);
					return; // 이벤트에 대한 리턴
				}
				JOptionPane.showMessageDialog(null, response.get("OK"), "OK", JOptionPane.INFORMATION_MESSAGE);
				mainCard.show(mainPanel, "loginPanel");  //화면 넘어감
				clearFields(registerFields); //넘어가고 화면 클리어 , 클릭이 되었을때 호출됨 , 생성자가 먼저 호출되어서 값이 이미 들어가있음, 화면전환이 일어날때마다 해줄것

				// userService.register(userJson.toString());
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("CookieRun Black", Font.BOLD, 18));
		lblNewLabel_1.setBounds(93, 370, 206, 37);
		registerPanel.add(lblNewLabel_1);
		
		loginFields.add(usernameField);
		loginFields.add(passwordField);
		
		registerFields.add(registerUsernameField);
		registerFields.add(registerPasswordField);
		registerFields.add(registerNameField);
		registerFields.add(registerEmailField);
	}  //생성자 호출이 여기까지 실행
	
	private void clearFields(List<JTextField> textFields) {  
		for(JTextField field : textFields) {
			if(field.getText().isEmpty()) {  //empty 스페이스바도 공백으로 본다
				continue;
			}
			field.setText("");
		}
		
	}

}
