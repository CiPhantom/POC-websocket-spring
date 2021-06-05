package websocket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import websocket.messagemodels.Player;
import websocket.messagemodels.PlayerManager;

@Component
public class SessionDisconnectEventManagement implements ApplicationListener<SessionDisconnectEvent> {

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @Override
    public void onApplicationEvent(SessionDisconnectEvent sessionDisconnectEvent) {
        StompHeaderAccessor.wrap(sessionDisconnectEvent.getMessage());
        String sessionId = sessionDisconnectEvent.getUser().getName();
        PlayerManager pManager = PlayerManager.getInstance();
        pManager.removeBySession(sessionId);
        messagingTemplate.convertAndSend("/topic/clean-user", sessionId);
    }
}
