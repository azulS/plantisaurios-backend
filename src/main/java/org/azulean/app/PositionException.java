package org.azulean.app;

import org.azulean.model.Position;

public class PositionException extends Exception {

    private final Position position;
    public PositionException(String message, Position position) {

        super(message);
        this.position = position;
    }
}
