package com.matsu.ebancoimobiliario.service;

import com.matsu.ebancoimobiliario.domain.Player;
import com.matsu.ebancoimobiliario.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
