package simplechatting.server;  //입장인원 리스트
ㅇ
import java.io.BufferedReader;  
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketOption;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
class ConnectedSocket extends Thread { //start 되면 run이 실행
	private static List<ConnectedSocket> socketList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	private String username;
	
	public ConnectedSocket(Socket socket) {
		this.socket = socket;
		socketList.add(this);
	}
	
	@Override
	public void run() {
		try {
			outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream,true);
			out.println("join");  //클라이언트한테 join text값을 준다
			//System.out.println(socket.getInetAddress() + "클라이언트가 연결되었습니다.");
			
			inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			
			username = in.readLine();  //전역변수가 아닌 멤버변수에다가
			System.out.println(username + "님이 접속하였습니다."); //서버 콘솔창에 띄움
			
				
				String userListStr = "";
				
				for(int i = 0; i < socketList.size(); i++) {
					userListStr += socketList.get(i).getUsername();  //넣어둔 옵션 꺼내기
					if(i < socketList.size() - 1) {
						userListStr += ",";
					}
				}
			
			for(ConnectedSocket connectedSocket : socketList) {
				outputStream = connectedSocket.getSocket().getOutputStream();
				out = new PrintWriter(outputStream, true);
				out.println("@welcome/" + username + "님이 접속하였습니다.");  //welcomeMessage를 모든 소켓에 뿌림
				out.println("@userList/" + userListStr);
			}
			
			while(true) {
				String message = in.readLine();  //응답이 올때까지 기다림 (서버종료를 막아줌)
				for(ConnectedSocket connectedSocket : socketList) {
					outputStream = connectedSocket.getSocket().getOutputStream();
					out = new PrintWriter(outputStream, true);
					out.println(message);   //모두한테 보내줘야한다
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class ServerApplication {

	public static void main(String[] args) {
			ServerSocket serverSocket = null;
			
			try {
				serverSocket = new ServerSocket(9090);  //try안에 지역변수가 있으면  finally에서 사용불가
				System.out.println("<<<서버 실행>>>");
				List<Socket> socketList = new ArrayList<>();
				
				while(true) { //서버 실행시 계속 반복함
					Socket socket = serverSocket.accept();  //클라이언트의 접속을 기다림 (연결버튼 누를때까지)  while안에 넣으면 매번 초기화
					ConnectedSocket connectedSocket = new ConnectedSocket(socket);
					connectedSocket.start();
						
					}
		
				
			} catch (IOException e) {
				e.printStackTrace();
				
			} finally {
				if(serverSocket != null) {
					try {
						serverSocket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println("<<<서버 종료>>>");
			}
		}
}
