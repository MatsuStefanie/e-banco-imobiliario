package com.matsu.ebancoimobiliario.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;
    String name;
    Integer amountBuyProperty;
    Integer mortgageAmount;
    @ManyToOne
    @JoinColumn(name = "player_id")
    Player owner;

}
