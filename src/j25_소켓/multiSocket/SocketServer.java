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

public class SocketServer extends Thread {
	
	public static List<SocketServer> clientList = new ArrayList<>();
	private Socket socket;
	private String name;
	
	public SocketServer(Socket socket) {
		this.socket = socket;
		clientList.add(this);  //자기 자신을 생성해서 담음 static이기에 가능
	}
	
	@Override
	public void run() {  //서버로서의 역할을 할 기능 넣기
		System.out.println("[연결된 클라이언트 정보]");
		System.out.println("IP: " + socket.getInetAddress());  //클라이언트의 ip주소 확인
		
		try {
			InputStream inputStream = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(outputStream, true);
			
			writer.println("서버 접속 성공!");  //서버가 클라이언트한테 프린트
			writer.println("사용자 이름을 입력하세요?");
			
			String message = null;
			boolean loginFlag = false;
			while((message = reader.readLine()) != null) {     //메세지 변수에 값을 대입하고 null인지 확인
				if(name == null) {
					name = message;
					System.out.println("\n서버에 " + name + "님이 접속하였습니다.");
				
				}

				for(SocketServer s : clientList) {
					try {
						outputStream = s.socket.getOutputStream();
						writer = new PrintWriter(outputStream, true);
						if(!loginFlag) {
							writer.println("\n" + s.name + "님이 접속하였습니다.");
							loginFlag = true;
							continue;
						}
						writer.println("\n" +s.name + ": " + message);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
