package simplechatting2.server;  //입장인원 리스트

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

import com.google.gson.Gson;

import lombok.Data;
import simplechatting2.dto.JoinRespDto;
import simplechatting2.dto.MessageReqDto;
import simplechatting2.dto.MessageRespDto;
import simplechatting2.dto.RequestDto;
import simplechatting2.dto.ResponseDto;
import simplechatting2.dto.joinReqDto;


@Data
class ConnectedSocket extends Thread { //start 되면 run이 실행
	private static List<ConnectedSocket> socketList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private Gson gson;
	
	private String username;  //접속을 했을때 이름을 넣어둠
	
	public ConnectedSocket(Socket socket) {
		this.socket = socket;
		gson = new Gson();
		socketList.add(this);
	}
	
	@Override
	public void run() {
		try {
			inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			
			while(true) {
				String request = in.readLine();  //requestDto(JSON)
				RequestDto requestDto = gson.fromJson(request, RequestDto.class);
				
				switch(requestDto.getResource()) {
					case "join":
						joinReqDto joinReqDto = gson.fromJson(requestDto.getBody(), joinReqDto.class);
						username = joinReqDto.getUsername();
						List<String> connectedUsers = new ArrayList<>();
						for(ConnectedSocket connectedSocket : socketList) {
							connectedUsers.add(connectedSocket.getUsername());
						}
						JoinRespDto joinRespDto = new JoinRespDto(username + "님이 접속하였습니다.", connectedUsers);
						sendToAll(requestDto.getResource(), "ok", gson.toJson(joinReqDto));  //모두한테 던짐
						break;
					case "sendMessage":
						MessageReqDto messageReqDto = gson.fromJson(requestDto.getBody(), MessageReqDto.class);
						
						if(messageReqDto.getToUser().equalsIgnoreCase("all")) {
							String message = messageReqDto.getFromUser() + "[전체]" + messageReqDto.getMessageValue();
							MessageRespDto messageRespDto = new MessageRespDto(message);
							sendToAll(requestDto.getResource(), "ok", gson.toJson(messageRespDto));
						} 
						
							
						
							
						
						break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void sendToAll(String resouce, String status, String body) throws IOException {
		ResponseDto responseDto = new ResponseDto(resouce, status, body);
		for(ConnectedSocket connectedSocket : socketList) {
			OutputStream outputStream = connectedSocket.getSocket().getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);
			
			out.println(gson.toJson(responseDto));  //모든 소켓에다 responseDto전달
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
					ConnectedSocket connectedSocket = new ConnectedSocket(socket); //ConnectedSocket = thread
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
