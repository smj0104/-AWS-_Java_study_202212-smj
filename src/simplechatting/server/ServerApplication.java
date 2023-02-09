package simplechatting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication {

	public static void main(String[] args) {
			ServerSocket serverSocket = null;
			
			try {
				serverSocket = new ServerSocket(9090);  //try안에 지역변수가 있으면  finally에서 사용불가
				System.out.println("<<<서버 실행>>>");
				
				Socket socket = serverSocket.accept();  //클라이언트의 접속을 기다림 (연결버튼 누를때까지)
				
				OutputStream outputStream = socket.getOutputStream();
				PrintWriter out = new PrintWriter(outputStream,true);
				out.println("join");  //클라이언트한테 join text값을 준다
				//System.out.println(socket.getInetAddress() + "클라이언트가 연결되었습니다.");


				InputStream inputStream = socket.getInputStream();
				BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
				
				String welcomeMessage = in.readLine();
				System.out.println(welcomeMessage); //서버 콘솔창에 띄움
				out.println(welcomeMessage); // 클라이언트한테 다시 돌려줌
				
				while(true) {
					in.readLine();  //응답이 올때까지 기다림 (서버종료를 막아줌)
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
