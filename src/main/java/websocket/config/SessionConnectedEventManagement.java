package websocket.config;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

@Component
public class SessionConnectedEventManagement implements ApplicationListener<SessionConnectedEvent> {

    @Override
    public void onApplicationEvent(SessionConnectedEvent sessionConnectedEvent) {
        StompHeaderAccessor.wrap(sessionConnectedEvent.getMessage());
    }
}
