package org.azulean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Position extends Persistente{

    @Column
    private final double x;
    @Column
    private final double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }


}
