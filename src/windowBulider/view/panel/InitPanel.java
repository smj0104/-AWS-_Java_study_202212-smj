package windowBulider.view.panel;

import javax.swing.JPanel;

public class InitPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private final int WIDTH = 600;
	private final int HEIGHT = 500;
	
	public InitPanel() {
		setLayout(null);
		setBorder(null);  //기본세팅
		setSize(WIDTH, HEIGHT);
	}
}
