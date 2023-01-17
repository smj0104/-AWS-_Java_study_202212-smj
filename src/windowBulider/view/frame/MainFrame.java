package windowBulider.view.frame;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import windowBulider.view.panel.MainPanel;

public class MainFrame extends JFrame{
	
//	private CardLayout mainCard;
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);  //틀만듬
		
		
		MainPanel mainPanel =MainPanel.getInstance();
		mainPanel.init();
		setContentPane(mainPanel);
		

		//mainCard = new CardLayout();  //레이아웃 적용  프레임 위에는 반드시 레이아웃이 필요
	
	
	}

}
