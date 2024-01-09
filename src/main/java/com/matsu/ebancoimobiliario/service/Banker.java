package com.matsu.ebancoimobiliario.service;

import com.matsu.ebancoimobiliario.domain.Account;
import com.matsu.ebancoimobiliario.domain.Player;
import com.matsu.ebancoimobiliario.domain.Property;
import com.matsu.ebancoimobiliario.repository.PlayerRepository;
import com.matsu.ebancoimobiliario.repository.StocksRepository;
import com.matsu.ebancoimobiliario.repository.StreetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Banker {

    private final PlayerRepository playerRepository;
    private final StreetRepository streetRepository;
    private final StocksRepository stocksRepository;

    private void registerProperty(Integer idPlayer, Integer idProperty) {
        Player player = findByIdOrThrowNotFound(idPlayer);
        var property = findProperty(idProperty);
        property.setOwner(player);

    }

    private Property findProperty(Integer idProperty) {
        return idProperty > 22 ?
                stocksRepository.findById(idProperty).orElseThrow() :
                streetRepository.findById(idProperty).orElseThrow();
    }

    private void saleProperty(Integer idProperty) {
        var property = findProperty(idProperty);
        property.setOwner(null);
    }

    private void negotiateProperty(Integer idPlayerSale, Integer idPlayerBuy, Integer value, Integer idProperty) {
        debitValue(idPlayerBuy, value);
        creditValue(idPlayerSale, value);
        registerProperty(idPlayerBuy, idProperty);
    }

    public void startGame() {
        var players = playerRepository.findAll();
        players.forEach(player -> player.getBankAccount().setBalance(25000));
    }

    public void revenueTurnover(Integer idPlayer) {
        creditValue(idPlayer, 2000);
    }

    public void debitValue(Integer idPlayer, Integer value) {
        if (validCanTransaction(idPlayer, value)) {
            Player player = findByIdOrThrowNotFound(idPlayer);
            var balance = getBalance(idPlayer) - value;
            Account account = new Account(player.getBankAccount().getId(), balance, player);
            player.setBankAccount(account);
            playerRepository.save(player);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }


    public void creditValue(Integer idPlayer, Integer value) {
        Player player = findByIdOrThrowNotFound(idPlayer);
        var balance = getBalance(idPlayer) + value;
        Account account = new Account(player.getBankAccount().getId(), balance, player);
        player.setBankAccount(account);
        playerRepository.save(player);
    }

    public Integer getBalance(Integer idPlayer) {
        Optional<Player> optionalPlayer = playerRepository.findById(idPlayer);
        return optionalPlayer.map(p -> p.getBankAccount().getBalance()).orElse(0);
    }

    public Boolean validCanTransaction(Integer idPlayer, Integer value) {
        var balance = getBalance(idPlayer);
        return balance >= value;
    }

    private Player findByIdOrThrowNotFound(Integer idPlayer) {
        return playerRepository.findById(idPlayer).orElseThrow();
    }

}
