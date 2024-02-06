package com.matsu.ebancoimobiliario.service;

import com.matsu.ebancoimobiliario.domain.Player;
import com.matsu.ebancoimobiliario.domain.Property;
import com.matsu.ebancoimobiliario.repository.StocksRepository;
import com.matsu.ebancoimobiliario.repository.StreetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final StreetRepository streetRepository;
    private final StocksRepository stocksRepository;

    public void transferProperty(Player player, Integer idProperty) {
        JpaRepository<? extends Property, Integer> repository = definedRepository(idProperty);
        var property = repository.findById(idProperty).orElseThrow();
        property.setOwner(player);
        this.save( property , repository);
    }

    public void save(Object property, JpaRepository repository) {
        repository.save(property);
    }

    private JpaRepository<? extends Property, Integer> definedRepository(Integer idProperty) {
        return isStocks(idProperty) ? stocksRepository :  streetRepository;
    }
    private boolean isStocks(Integer idProperty) {
        return idProperty > 22;
    }

}
