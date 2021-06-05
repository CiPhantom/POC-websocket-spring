package websocket.messagemodels;

public class Player {

    private String associatedSession;
    private String roomSlug;
    private String playerName;
    private boolean hasSelectedCard;
    private Integer choosenValue;

    public Player(){}

    public Player(String roomSlug, String playerName) {
        this.roomSlug = roomSlug;
        this.playerName = playerName;
        this.hasSelectedCard = false;
        this.choosenValue = null;
    }

    public Player(String roomSlug, String playerName , Integer choosenValue) {
        this.roomSlug = roomSlug;
        this.playerName = playerName;
        this.hasSelectedCard = false;
        this.choosenValue = choosenValue;
    }

    public String getAssociatedSession() {
        return associatedSession;
    }

    public void setAssociatedSession(String associatedSession) {
        this.associatedSession = associatedSession;
    }

    public Player withAssociatedSession(String associatedSession) {
        this.associatedSession = associatedSession;
        return this;
    }

    public String getRoomSlug() {
        return roomSlug;
    }

    public void setRoomSlug(String roomSlug) {
        this.roomSlug = roomSlug;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean isHasSelectedCard() {
        return hasSelectedCard;
    }

    public void setHasSelectedCard(boolean hasSelectedCard) {
        this.hasSelectedCard = hasSelectedCard;
    }

    public Integer getChoosenValue() {
        return choosenValue;
    }

    public void setChoosenValue(Integer choosenValue) {
        this.choosenValue = choosenValue;
    }
}
