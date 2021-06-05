package websocket.roomcontroller.models;

import websocket.messagemodels.Player;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String roomSlug;
    private List<Player> userList;

    public Room(String roomSlug, List userList) {
        this.roomSlug = roomSlug;
        this.userList = userList;
    }

    public String getRoomSlug() {
        return roomSlug;
    }

    public void setRoomSlug(String roomSlug) {
        this.roomSlug = roomSlug;
    }

    public List<Player> getUserList() {
        return userList;
    }

    public void setUserList(List<Player> userList) {
        this.userList = userList;
    }
}
