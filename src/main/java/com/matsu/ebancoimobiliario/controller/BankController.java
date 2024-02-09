package com.matsu.ebancoimobiliario.controller;

import com.matsu.ebancoimobiliario.domain.Player;
import com.matsu.ebancoimobiliario.service.BankerService;
import com.matsu.ebancoimobiliario.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("bank")
public class BankController {

    private final BankerService bankerService;
    private final PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> findPlayers() {
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping(path = "/{idPlayer}")
    public ResponseEntity<Player> getPlayer(@PathVariable int idPlayer) {
        return ResponseEntity.ok(playerService.findByIdOrThrowNotFound(idPlayer));
    }

    @GetMapping(path = "/saldo/{idPlayer}")
    public ResponseEntity<Integer> getBalance(@PathVariable int idPlayer) {
        return ResponseEntity.ok(playerService.getBalance(idPlayer));
    }

    @PutMapping
    public ResponseEntity<Void> startANewGame() {
        bankerService.startGame();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(path = "/{idPlayer}")
    public ResponseEntity<Void> passToStart(@PathVariable int idPlayer) {
        bankerService.revenueTurnover(idPlayer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
