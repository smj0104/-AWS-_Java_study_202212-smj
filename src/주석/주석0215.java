package 주석;

import java.util.List;

import javax.swing.JTextArea;

public class 주석0215 {
/* Socket project
 * 방 나갈때 회원 나감 표시와 이전 화면으로 이동 
 * cardlayout 사용
 * 방장이 방을 닫으면 다 같이 이전 화면으로 방은 리스트에서 삭제 (정 불가능하면 방은 유지)
 * 화면 비율 가로 480 세로 800
 * 클라 / 서버 하루마다 돌아가면서 
 * 각각의 프로젝트 마다 main문이 하나만 있어야한다
 * 
 * https://lcodea.tistory.com/22 소켓채팅 참고
 * 
 * 한번에 해결하려하지말고 하나씩 천천히 할것
 * 
 * 클라dto 서버dto 따로
 * 이미지 사이즈 맞추는 법 찾기
 * 
 * (가능하면 시도해볼것)
 * 중복 이름 불가
 * 
 * 
 * 아이콘
 * https://www.flaticon.com/
 * 
 * 카카오 아이콘
 * https://developers.kakao.com/
 * 카카오 메시지 푸시
 * https://developers.kakao.com/docs/latest/ko/push/common
 * 
 * https://thsd-stjd.tistory.com/147 참고
 * https://m.blog.naver.com/simhs93/221980987519
 * https://myhappyman.tistory.com/103
 * 
 * 
 * 
 * HashMap 을 리스트로 관리해서 새로 들어오는 id에 대해서 리스트를 for문돌면서

존재하는지 확인한다음 있으면 중복이라고 보내고

없으면 새로 add 해주고 진행하심 되시겠네요..

해당 id가 퇴장하면 제거해주시공.


 * private void clearFields(List<JTextArea> textArea) {
		for(JTextArea field : textArea) {
			if(field.getText().isEmpty()) {
				continue;
			}
			field.setText("");
		}
	}
	클라 리시브
	responseDto.getUserId() + ": " +  추가
	
	
	클라 리스트 모델
	public void mouseClicked(MouseEvent e) {
				String enterRoom = roomList.getSelectedValue();
				if (e.getClickCount() == 2) {
					if (enterRoom != null) {
						
						enterRoomname = enterRoom;
						RequestDto<?> reqEnter = RequestDto.<String>builder()
															.resource("enter")
															.username(username)
															.enterRoomname(enterRoom)
															.body(enterRoom)
															.build();
						sendRequest(reqEnter);
						ChatArea.setText("");
						chattingRoomName.setText("제목: " + enterRoom + "의 방");
						mainCard.show(MainPanel, "ChattingPanel");
						
					}
	
	

소켓서버
  case "sendMessage":
	            String message = (String) requestDto.getBody();
	            enterRoomName = (String) requestDto.getEnterRoomname();
	            String username1 = (String)requestDto.getUsername();
	            
	            ResponseDto<?> messageResponseDto = ResponseDto.<String>builder()
	            												.resource("sendMessage")
														.body(message)							
	            												.room(room)
	            												.username(username)
	            												.roomName(roomName)
	            												.build();
	            sendToRoom(messageResponseDto,roomName);
	            break;
	            
	         클라챗   
	private void sendMessage() {
		if (!messageInput.getText().isBlank()) {
			RequestDto<?> messageReqDto = RequestDto.<String>builder()
													.resource("sendMessage")
													.username(username)
													.enterRoomname(enterRoomname)
													.body(messageInput.getText())
													.build();
			sendRequest(messageReqDto);
			messageInput.setText("");

		}
	}
 */
}
