package org.azulean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Tree extends Persistente{
    @Column
    private String produce;
    @OneToOne
    private Position position;

    public Tree(String produce, Position position) {
        this.produce = produce;
        this.position = position;
    }

}
