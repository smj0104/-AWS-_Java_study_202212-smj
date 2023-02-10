package simplechatting.client;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChattingClient extends JFrame {
	
	private Socket socket;
	private String username;

	private JPanel contentPane;
	private JTextField ipInput;
	private JTextField portInput;
	private JTextArea contentView;
	private JTextField messageInput;
	private JList userList;
	private DefaultListModel<String> userListModel;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingClient frame = new ChattingClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ChattingClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		portInput = new JTextField();
		portInput.setText("9090");
		portInput.setBounds(454, 10, 72, 44);
		contentPane.add(portInput);
		portInput.setColumns(10);
		
		JButton connectButton = new JButton("연결");
		connectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ip = null;
				int port = 0;
				
				ip = ipInput.getText();
				port = Integer.parseInt(portInput.getText());
				
				try {
					socket = new Socket(ip, port);
					
					JOptionPane.showMessageDialog(null,
							socket.getInetAddress() + "서버 접속",
							"접속 성공",
							JOptionPane.INFORMATION_MESSAGE);
					
					InputStream inputStream = socket.getInputStream();  //서버로부터 데이터를 받는 통로를 열어줌
					BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
					
					if(in.readLine().equals("join")) {
						username = JOptionPane.showInputDialog(null, "사용자이름을 입력하세요.", JOptionPane.INFORMATION_MESSAGE);  //username
						
						OutputStream outputStream = socket.getOutputStream();
						PrintWriter out = new PrintWriter(outputStream,true);
					
						out.println(username);
					}
					
					Thread thread = new Thread(() -> {
						try {
							InputStream input = socket.getInputStream();
							BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
							
							while(true) {  //혼자서 계속 도는 스레드
								String message = reader.readLine();
								if(message.startsWith("@welcome")) { 	//@로 시작하는가 확인
									int tokenIndex = message.indexOf("/");
									message = message.substring(tokenIndex + 1); // 웰컴메시지만 잘라서 보내줌
								}else if(message.startsWith("@userList")) {
									int tokenIndex = message.indexOf("/");
									message = message.substring(tokenIndex + 1);
									String[] usernames = message.split(",");
									userListModel.clear();
									for(String username : usernames) {
										userListModel.addElement(username);  //addelements는 자동으로 증가
									}
									continue;
								}
								contentView.append(message + "\n" );
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					});
					
					 thread.start(); //위의 스레드를 실행하라 계속 메시지를 받아줌
					
				} catch (ConnectException e1) {
					
							JOptionPane.showMessageDialog(null,
									"서버 접속 실패",
									"접속 실패",
									JOptionPane.ERROR_MESSAGE);
					
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		connectButton.setBounds(538, 9, 134, 44);
		contentPane.add(connectButton);
		
		ipInput = new JTextField();
		ipInput.setText("127.0.0.1");
		ipInput.setBounds(288, 10, 154, 44);
		contentPane.add(ipInput);
		ipInput.setColumns(10);
		
		JScrollPane contentScroll = new JScrollPane();
		contentScroll.setBounds(12, 10, 264, 365);
		contentPane.add(contentScroll);
		
		contentView = new JTextArea();
		contentScroll.setViewportView(contentView);
		
		JScrollPane userLIstScroll = new JScrollPane();
		userLIstScroll.setBounds(288, 74, 373, 301);
		contentPane.add(userLIstScroll);
		
		userListModel = new DefaultListModel<>();
		userList = new JList(userListModel);
		userLIstScroll.setViewportView(userList);
		
		JScrollPane messageScroll = new JScrollPane();
		messageScroll.setBounds(12, 397, 521, 54);
		contentPane.add(messageScroll);
		
		messageInput = new JTextField();
		messageInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) { //키보드입력으로 동작함
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {  //리턴이 int  enter와 값이 같으면 동작
					if(!messageInput.getText().isBlank()) {  //공백이면 날리면 안된다(비어있지않을때만 동작하게)
						try {
							OutputStream outputStream = socket.getOutputStream();
							PrintWriter out = new PrintWriter(outputStream, true);
							
							out.println(username + ": " + messageInput.getText());  //
							messageInput.setText("");
							
						}	catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		messageScroll.setViewportView(messageInput);
		
		JButton sendButton = new JButton("전송");
		sendButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!messageInput.getText().isBlank()) {  //공백이면 날리면 안된다(비어있지않을때만 동작하게)
				try {
					OutputStream outputStream = socket.getOutputStream();
					PrintWriter out = new PrintWriter(outputStream, true);
					
					out.println(username + ": " + messageInput.getText());  //
					messageInput.setText("");
					
				} catch (IOException e1) {
					e1.printStackTrace();
					}
				}
			}
		});
		sendButton.setBounds(544, 399, 128, 44);
		contentPane.add(sendButton);
	}
}
