package org.azulean.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.azulean.model.Persistente;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Position extends Persistente {
    @Column
    private double x;
    @Column
    private double y;
    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }
}