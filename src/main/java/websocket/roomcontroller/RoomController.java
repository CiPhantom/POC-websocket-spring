package websocket.roomcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import websocket.messagemodels.AuthenticationMessage;
import websocket.messagemodels.Player;
import websocket.messagemodels.PlayerManager;
import websocket.roomcontroller.models.Room;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
public class RoomController {

    PlayerManager playerManager = PlayerManager.getInstance();

    @PostMapping("/room")
    public ResponseEntity<Room> getRoom(@RequestBody AuthenticationMessage authenticationMessage) {
        if("capgemini".equalsIgnoreCase(authenticationMessage.getRoomKeyWord())) {
            List players = playerManager.getPlayers();
            if(!playerManager.doesThisUserExist(authenticationMessage.getUserId())) {
                players.add(
                        new Player(
                                authenticationMessage.getRoomKeyWord(),
                                authenticationMessage.getPlayerName()).
                                withAssociatedSession(authenticationMessage.getUserId()));
            }

            return new ResponseEntity<>(new Room("CAPGEMINI", players), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
