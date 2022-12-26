package org.azulean;

public class PositionException extends Exception {

    private final Position position;
    public PositionException(String message, Position position) {

        super(message);
        this.position = position;
    }
}
