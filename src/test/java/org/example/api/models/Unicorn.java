package org.example.api.models;

public class Unicorn {
    private String name;
    private String tailColor;

    public Unicorn(String name, String colorOfTail) {
        this.name = name;
        this.tailColor = colorOfTail;
    }

    public void setTailColor(String tailColor) {
        this.tailColor = tailColor;
    }

    public String toJson() {
        return "{\"name\":\"" + name + "\",\"tailColor\":\"" + tailColor + "\"}";
    }
}
