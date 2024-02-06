package com.matsu.ebancoimobiliario.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Stocks extends Property {

    private Integer multiplierDice;

}
