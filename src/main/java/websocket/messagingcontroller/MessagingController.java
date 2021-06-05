package websocket.messagingcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import websocket.messagemodels.*;

import java.security.Principal;
import java.util.List;

@Controller
public class MessagingController {

    PlayerManager playerManager = PlayerManager.getInstance();

    @Autowired
    SimpMessagingTemplate messagingTemplate;


    @MessageMapping("/clean-user")
    @SendTo("/topic/clean-user")
    public String removeDisconnectedUser(SimpMessageHeaderAccessor headerAccessor) throws Exception {
        return null;
    }

    @MessageMapping("/user-entered-room")
    @SendTo("/topic/user-entered-room")
    public Player userEnteredRoomEvent(@Payload AuthenticationMessage message, SimpMessageHeaderAccessor headerAccessor, Principal principal) throws Exception {
        return playerManager.getBySession(principal.getName());
    }

    @MessageMapping("/user-did-vote")
    @SendTo("/topic/user-did-vote")
    public Player userDidAVote(@Payload Player message, SimpMessageHeaderAccessor headerAccessor, Principal principal) throws Exception {
        Player p = playerManager.getBySession(message.getAssociatedSession());
        p.setChoosenValue(message.getChoosenValue());
        p.setHasSelectedCard(message.isHasSelectedCard());
        return p;
    }

    @MessageMapping("/show-cards")
    @SendTo("/topic/show-cards")
    public SimpleTextMessage userSentShowCards() throws Exception {
        return new SimpleTextMessage("showcards");
    }

    @MessageMapping("/new-vote")
    @SendTo("/topic/new-vote")
    public SimpleTextMessage userSentNewVote() throws Exception {
        return new SimpleTextMessage("newvote");
    }
}