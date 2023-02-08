package j25_소켓.multiSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.ByteString.Output;

public class SocketServer extends Thread {
	
	public static List<SocketServer> clientList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	private static int autoIncrement = 1;
	private String name;
	
	public SocketServer(Socket socket) {
		this.socket = socket;
		name = "user" + autoIncrement++;
		clientList.add(this);  //자기 자신을 생성해서 담음 static이기에 가능
	}
	
	@Override
	public void run() {  //서버로서의 역할을 할 기능 넣기
		System.out.println("[연결된 클라이언트 정보]");
		System.out.println("IP: " + socket.getInetAddress());  //클라이언트의 ip주소 확인
		
		try {
			inputStream = socket.getInputStream();  //메시지가 서버로 들어올때 사용
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			sendToAll(name + "님이 접속하였습니다.");
			
			while(true) {
				String message = reader.readLine();
				if(message == null) {
					break;
				}
				sendToAll(message);
			}
			
//			writer.println("서버 접속 성공!");  //서버가 클라이언트한테 프린트
//			writer.println("사용자 이름을 입력하세요?");
			
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				inputStream.close();
				outputStream.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	private void sendToAll(String message) throws IOException {  
		for(SocketServer socketServer : clientList) {  //클라이언트 리스트에서 소켓서버 하나 꺼냄
			outputStream = socketServer.socket.getOutputStream(); 
			PrintWriter writer = new PrintWriter(outputStream, true);
			writer.println(name + ": " + message);    //name = 멤버변수에 든 name 
		}
	}
}
