package websocket.messagemodels;

import example.avro.User;

public class AuthenticationMessage {

    private String userId;
    private String playerName;
    private String roomKeyWord;

    public AuthenticationMessage(String playerName, String roomKeyWord) {
        this.playerName = playerName;
        this.roomKeyWord = roomKeyWord;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getRoomKeyWord() {
        return roomKeyWord;
    }

    public void setRoomKeyWord(String roomKeyWord) {
        this.roomKeyWord = roomKeyWord;
    }
}
