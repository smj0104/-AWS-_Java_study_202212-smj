package simplechatting2.client;

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

import com.google.gson.Gson;

import lombok.Data;
import lombok.Getter;
import simplechatting2.dto.MessageReqDto;
import simplechatting2.dto.RequestDto;
import simplechatting2.dto.joinReqDto;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@Getter
public class ChattingClient extends JFrame {
	private static ChattingClient instance;
	
	public static ChattingClient getInstance() {
		if(instance == null) {
			instance = new ChattingClient();
		}
		return instance;
	}
	
	private Socket socket;
	private Gson gson;
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
					ChattingClient frame = ChattingClient.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private ChattingClient() {
		gson = new Gson();
		
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
		
		JButton connectButton = new JButton("연결");  //연결 버튼을 클릭했을때 연결시도
		
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
					ClientRecieve clientRecieve = new ClientRecieve(socket);
					clientRecieve.start();
					
					username = JOptionPane.showInputDialog(null,"사용자 이름을 입력해 주세요.", "이름입력", JOptionPane.INFORMATION_MESSAGE);
					joinReqDto joinReqDto = new joinReqDto(username);
					String joinReqDtoJson = gson.toJson(joinReqDto);
					RequestDto requestDto = new RequestDto("join", joinReqDtoJson);
					String requestDtoJson = gson.toJson(requestDto);  //서버한테 사용자 이름넣어서 보내준다
					
					OutputStream outputStream = socket.getOutputStream();
					PrintWriter out = new PrintWriter(outputStream, true);
					out.println(requestDtoJson);
					
					
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

							MessageReqDto messageReqDto =
									new MessageReqDto("all", username, messageInput.getText());
							
							sendRequest("sendMessage", gson.toJson(messageReqDto));
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
	
	private void sendRequest(String resource, String body) {
		OutputStream outputStream;
		try {
			outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);
			
			RequestDto requestDto = new RequestDto(resource, body);
			
			out.println(gson.toJson(requestDto));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
