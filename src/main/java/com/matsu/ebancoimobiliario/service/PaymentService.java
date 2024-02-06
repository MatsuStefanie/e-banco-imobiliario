package com.matsu.ebancoimobiliario.service;

import com.matsu.ebancoimobiliario.domain.Account;
import com.matsu.ebancoimobiliario.domain.Player;
import com.matsu.ebancoimobiliario.repository.NoticeRepository;
import com.matsu.ebancoimobiliario.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final NoticeRepository noticeRepository;
    private final PlayerRepository playerRepository;

    private final PlayerService playerService;

    public Player notice(Integer idPlayer, Integer idNotice) {
        var notice = noticeRepository.findById(idNotice).orElseThrow();

        if (notice.isMisfortune()) {
            debitValue(idPlayer, notice.getValue());
        } else {
            creditValue(idPlayer, notice.getValue());
        }
        return playerService.findByIdOrThrowNotFound(idNotice);
    }

    public List<Player> bigNotice(Integer idPlayer) {
        var players = playerRepository.findAll();
        players.stream()
                .peek(player -> debitValue(player.getId(), 500))
                .forEach(playerRepository::save);
        creditValue(idPlayer, players.size() * 500);
        return playerRepository.findAll();
    }

    public void creditValue(Integer idPlayer, Integer value) {
        Player player = playerService.findByIdOrThrowNotFound(idPlayer);
        var balance = playerService.getBalance(idPlayer) + value;
        Account account = new Account(player.getBankAccount().getId(), balance, player);
        player.setBankAccount(account);
        playerRepository.save(player);
    }

    public void debitValue(Integer idPlayer, Integer value) {
        if (validCanTransaction(idPlayer, value)) {
            Player player = playerService.findByIdOrThrowNotFound(idPlayer);
            var balance = playerService.getBalance(idPlayer) - value;
            Account account = new Account(player.getBankAccount().getId(), balance, player);
            player.setBankAccount(account);
            playerRepository.save(player);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    private Boolean validCanTransaction(Integer idPlayer, Integer value) {
        var balance = playerService.getBalance(idPlayer);
        return balance >= value;
    }

}
