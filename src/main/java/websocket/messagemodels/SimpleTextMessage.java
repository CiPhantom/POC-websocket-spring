package websocket.messagemodels;

public class SimpleTextMessage {
    private String text;

    public SimpleTextMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
