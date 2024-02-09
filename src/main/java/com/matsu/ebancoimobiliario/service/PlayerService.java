package com.matsu.ebancoimobiliario.service;

import com.matsu.ebancoimobiliario.domain.Player;
import com.matsu.ebancoimobiliario.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {


    private final PlayerRepository playerRepository;

    public Player findByIdOrThrowNotFound(Integer idPlayer) {
        return playerRepository.findById(idPlayer).orElseThrow();
    }

    public Integer getBalance(Integer idPlayer) {
        Player player = findByIdOrThrowNotFound(idPlayer);
        return player.getBankAccount().getBalance();
    }

    public List<Player> createList(Integer idPlayerBuyer, Integer idPlayerSale) {

        List<Player> players = new ArrayList<>();
        players.add(findByIdOrThrowNotFound(idPlayerSale));
        players.add(findByIdOrThrowNotFound(idPlayerBuyer));
        return players;
    }


    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public void injectToEverbody(Integer value) {
        var players = findAll();
        players
                .stream()
                .peek(player -> player
                        .getBankAccount()
                        .setBalance(value))
                .forEach(playerRepository::save);
    }
}
