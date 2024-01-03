package com.matsu.ebancoimobiliario.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL)
    private Account bankAccount;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Street> streets;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Stocks> stocks;

}
