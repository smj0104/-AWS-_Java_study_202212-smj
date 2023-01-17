package windowBulider.view.panel;

import java.awt.CardLayout;



import javax.swing.JPanel;

import lombok.Data;
@Data
public class MainPanel extends InitPanel {

	private static final long serialVersionUID = 1L;  //직렬화?

	private CardLayout mainCard;
	
	private static MainPanel instance;
	
	public static MainPanel getInstance() {
		if(instance == null) {
			instance = new MainPanel();
		}
		return instance;
	}
	
	
	private MainPanel() {  //생성자는 바깥에서 생성되면 안되기에 private
		mainCard = new CardLayout();
	//	setSize(600, 500);  //setBound 너비 높이까지 같이
		setLayout(mainCard);
		

	}
	public void init() {
		LoginPanel loginpanel = new LoginPanel();
		add(loginpanel, "loginPanel");
		
		RegisterPanel registerpanel = new RegisterPanel();
		add(registerpanel, "registerPanel");
	}
}
