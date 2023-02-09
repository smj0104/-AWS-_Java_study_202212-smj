package usermanagement.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UserManagementServerApplication implements Runnable {
	
	private final static int PORT = 9090;
	private ServerSocket serverSocket;
	
	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(PORT);  //서버 하나 열기
			System.out.println("==========<< 서버 실행 >>==========");
			
			socketConnection();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(serverSocket != null) {
					serverSocket.close();
				}
				System.out.println("==========<< 서버 종료 >>==========");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void socketConnection() throws IOException {
		while(true) {
			Socket socket = serverSocket.accept();  //클라이언트의 연결 기다림 (무한반복중) 메소드 호출시 소켓 생성함
			SocketServer socketServer = new SocketServer(socket);
			socketServer.start();
		}
	}

	public static void main(String[] args) {
		UserManagementServerApplication application = new UserManagementServerApplication();
		application.run();
	}
	
}







