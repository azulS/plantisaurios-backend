package org.azulean;

public class Tree {

    private String produce;
    private Position position;

    public Tree(String produce, Position position) {
        this.produce = produce;
        this.position = position;
    }

    public String getProduce() {
        return produce;
    }

    public Position getPosition() {
        return position;
    }
}
