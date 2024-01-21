package websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component//("chatWebsocketHandler")
public class ChatWebsocketHandler extends TextWebSocketHandler {

	List<WebSocketSession> list = new ArrayList();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println(session.getRemoteAddress() + " 에서 접속했습니다.");
		list.add(session);
	}
	
	@Override
	public void handleMessage(WebSocketSession session, 
			WebSocketMessage<?> message) throws Exception {
		// 웹소켓 연결 클라이언(session) 가 메시지(message) 보낼 때 자동 실행
		// 나머지 클라이언트(list)에게 전송 구현 
		String msg = (String)message.getPayload();
		for (WebSocketSession socket : list) {
			WebSocketMessage<String> sendMsg = new TextMessage(msg);
			socket.sendMessage(message);
		}
		
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session.getRemoteAddress() + " 에서 해제했습니다.");
		list.remove(session);
	}
	

}
