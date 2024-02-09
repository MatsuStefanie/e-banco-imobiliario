package com.matsu.ebancoimobiliario.service;

import com.matsu.ebancoimobiliario.domain.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankerService {

    private final PropertyService propertyService;
    private final PlayerService playerService;
    private final PaymentService paymentService;

    public void registerProperty(Integer idPlayer, Integer idProperty) {
        Player player = playerService.findByIdOrThrowNotFound(idPlayer);
        propertyService.transferProperty(player, idProperty);

    }

    public List<Player> negotiateProperty(Integer idPlayerSale, Integer idPlayerBuy, Integer value, Integer idProperty) {

        paymentService.debitValue(idPlayerBuy, value);
        paymentService.creditValue(idPlayerSale, value);
        registerProperty(idPlayerBuy, idProperty);
        List<Player> players = new ArrayList<>();
        players.add(playerService.findByIdOrThrowNotFound(idPlayerSale));
        players.add(playerService.findByIdOrThrowNotFound(idPlayerBuy));
        return players;
    }

    public List<Player> mortgage(Integer idPlayerSale, Integer idPlayerBuy, Integer value) {
        paymentService.debitValue(idPlayerBuy, value);
        paymentService.creditValue(idPlayerSale, value);
        return playerService.createList(idPlayerBuy, idPlayerSale);
    }

    public void startGame() {
        playerService.injectToEverbody(25000);

    }

    public void revenueTurnover(Integer idPlayer) {
        paymentService.creditValue(idPlayer, 2000);
    }


}
