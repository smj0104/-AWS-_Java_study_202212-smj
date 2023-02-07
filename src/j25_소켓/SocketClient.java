package j25_소켓;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1" , 9090);  //try catch   생성될때 마다 소켓을 리스트에 담아주겠다
			System.out.println("서버에 접속 성공!");
			
			InputStream inputStream = socket.getInputStream();  //그냥 못쓰고 버퍼기능이 필요
			InputStreamReader streamReader = new InputStreamReader(inputStream);  //읽기전용 한바이트씩 읽음
			BufferedReader reader = new BufferedReader(streamReader);  //버퍼를 쓴다 == 한뭉탱이로 묶어서 보겠다 
			
			System.out.println(reader.readLine());  //한 줄을 읽음  read() == 아스키코드로 하나 출력
			
			
		} catch (UnknownHostException e) {  //ip를 못잡을때
			e.printStackTrace();
		} catch (IOException e) { //통신을 하지못하였을때,인터넷 끊김등
			e.printStackTrace();
		}
	}

}
