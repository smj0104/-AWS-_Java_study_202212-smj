package j25_소켓.multiSocket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientReceive extends Thread {
	
	private final Socket socket;  //final로 잡아서 생성시 반드시 들어옴
	
	@Override
	public void run() {
		try {
			InputStream inputStream = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			while(true) {
					System.out.println(reader.readLine());
				}
				//System.out.println(reader.readLine());  //무한루프 돌면서 출력 (readLine)이 한번씩 들어올때 마다 출력
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
