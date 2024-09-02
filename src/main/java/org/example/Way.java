package org.example;

public enum Way {

    TOP("TOP"),
    RIGHT("RIGHT"),
    BOT("BOT"),
    LEFT("LEFT");
    private String side;
        Way(String side) {
        this.side = side;
    }
    public String getSide() {
        return side;
    }
}
