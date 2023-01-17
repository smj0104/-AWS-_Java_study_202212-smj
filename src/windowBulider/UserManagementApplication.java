package windowBulider;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;

import windowBulider.view.frame.MainFrame;

public class UserManagementApplication{
	private CardLayout mainCard;
	private JPanel mainPanel;  //멤버 변수

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Runnable runnable = new Runnable() {
		
			public void run() {
				try {
					MainFrame frame = new MainFrame();  //프레임생성
					frame.setVisible(true); //프레임이 보이는 단계 false시 안보임
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		//
		EventQueue.invokeLater(runnable); 
	}

	/**
	 * Create the frame.
//	 */
//	public UserManagementApplication() {//생성자
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 600, 500);  //상속받았기에 호출해서 사용가능
//		
//		mainCard = new CardLayout();
//		
//		mainPanel = new JPanel();
//		mainPanel.setLayout(mainCard);
//		mainPanel.setBorder(null);
//
//		setContentPane(mainPanel);
//		
//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.setBounds(242, 10, 97, 23); // x축 y축 너비 높이
//		contentPane.add(btnNewButton);  //패널에 버튼 객체를 추가함
//		
//		JButton btnNewButton_1 = new JButton("New button");
//		btnNewButton_1.setBounds(344, 10, 97, 23);
//		//btnNewButton.setVisible(false);//모든 객체에는 setVisible이 존재 
//		contentPane.add(btnNewButton_1);  
	

}
