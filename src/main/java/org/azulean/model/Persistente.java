package org.azulean.model;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
public abstract class Persistente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}