package j25_소켓;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer {
	
	public static final int PORT = 9090;  //서버를 만드는데 꼭 필요하고 포트번호로 서버를 연다
	
	public static void main(String[] args) {
		List<Socket> clients = new ArrayList<>();
		
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);  //소켓객체 생성
			while(true) {
				System.out.println("클라이언트의 접속을 기다리는 중입니다.");
				Socket socket = serverSocket.accept();  //클라이언트의 접속을 기다림  접속해야 accept가 넘어간다 연결시 소켓객체 하나 생성    소켓 하나 = 클라이언트 하나
				clients.add(socket);
				System.out.println("클라이언트가 연결되었습니다.");
				System.out.println(clients);
				OutputStream outputStream = socket.getOutputStream();
				PrintWriter out = new PrintWriter(outputStream,true);
				out.println("===서버에 접속한 것을 환영합니다.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
