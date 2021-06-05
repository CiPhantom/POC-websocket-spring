package websocket.messagemodels;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    List<Player> players;

    private static PlayerManager playerManager;

    public static PlayerManager getInstance() {
        if(playerManager != null ) return playerManager;
        else {
            playerManager = new PlayerManager();
            return playerManager;
        }
    }

    public PlayerManager(List<Player> players) {

        this.players = players;
    }

    public PlayerManager() {
        this.players = new ArrayList<>();
    }

    public Player addPlayer(Player p) throws Exception {
        if(this.players.size() <= 12 ) {
            this.players.add(p);
            return p;
        }
        throw new Exception("Scrum Rule : A scrum team shouldn't have more than 10 persons. (+ 2 spectators)");
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public static PlayerManager getPlayerManager() {
        return playerManager;
    }

    public static void setPlayerManager(PlayerManager playerManager) {
        PlayerManager.playerManager = playerManager;
    }

    public void removeBySession(String sessionId) {
        Player sessionToFind = null;
        for(Player p: this.players) {
            if(sessionId.equals(p.getAssociatedSession())) {
                sessionToFind = p;
            }
        }
        if(sessionToFind != null) {
            this.players.remove(sessionToFind);
        }
    }

    public Player getBySession(String sessionId) {
        Player sessionToFind = null;
        for(Player p: this.players) {
            if(sessionId.equals(p.getAssociatedSession())) {
                sessionToFind = p;
            }
        }
        if(sessionToFind != null) {
            return sessionToFind;
        }
        return null;
    }

    public boolean doesThisUserExist(String attachedSessionId) {
        Player sessionToFind = null;
        for(Player p: this.players) {
            if(attachedSessionId.equals(p.getAssociatedSession())) {
                sessionToFind = p;
            }
        }
        if(sessionToFind != null) {
            return true;
        } return false;
    }
}
