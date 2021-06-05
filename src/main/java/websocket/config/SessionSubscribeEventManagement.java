package websocket.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

@Component
public class SessionSubscribeEventManagement implements ApplicationListener<SessionSubscribeEvent> {

    @Override
    public void onApplicationEvent(SessionSubscribeEvent sessionSubscribeEvent) {
        StompHeaderAccessor.wrap(sessionSubscribeEvent.getMessage());
    }
}
