package websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class MyWebsocketConfig implements WebSocketConfigurer{

	ChatWebsocketHandler chatWebsocketHandler;
		
	public MyWebsocketConfig(ChatWebsocketHandler chatWebsocketHandler) {
		super();
		this.chatWebsocketHandler = chatWebsocketHandler;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(chatWebsocketHandler , "/ws").setAllowedOrigins("*");
		
	}
 
}



