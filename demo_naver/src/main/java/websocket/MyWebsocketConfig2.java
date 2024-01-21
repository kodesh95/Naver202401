package websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class MyWebsocketConfig2 implements WebSocketConfigurer{

	ChatWebsocketHandler chatWebsocketHandler;
	
	public MyWebsocketConfig2(ChatWebsocketHandler chatWebsocketHandler) {
		super();
		this.chatWebsocketHandler = chatWebsocketHandler;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(chatWebsocketHandler,"/ws").setAllowedOrigins("*");
	} 
	
	
}



