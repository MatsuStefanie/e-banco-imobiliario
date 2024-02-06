package com.matsu.ebancoimobiliario.controller;

import com.matsu.ebancoimobiliario.domain.Player;
import com.matsu.ebancoimobiliario.dto.request.RequestMontgageDTO;
import com.matsu.ebancoimobiliario.dto.request.RequestNegociationDTO;
import com.matsu.ebancoimobiliario.service.BankerService;
import com.matsu.ebancoimobiliario.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("payment")
public class PaymentController {

    private final PaymentService paymentService;
    private final BankerService bankerService;

    @PutMapping(path = "/negociacoes")
    public ResponseEntity<List<Player>> negociation(@RequestBody RequestNegociationDTO negociationDTO) {
        return ResponseEntity.ok(bankerService.negotiateProperty(
                negociationDTO.getIdSaler(),
                negociationDTO.getIdBuyer(),
                negociationDTO.getValueProperty(),
                negociationDTO.getIdProperty()));
    }

    @PutMapping(path = "/aluguel")
    public ResponseEntity<List<Player>> mortgage(@RequestBody RequestMontgageDTO montgageDTO) {
        return ResponseEntity.ok(bankerService.mortgage(
                montgageDTO.getIdSaler(),
                montgageDTO.getIdBuyer(),
                montgageDTO.getValue()));
    }

    @PatchMapping(path = "/notice/{idNotice}/{idPlayer}")
    public ResponseEntity<Player> notice(@PathVariable Integer idPlayer, @PathVariable Integer idNotice) {
        return ResponseEntity.ok(paymentService.notice(idPlayer,idNotice));
    }
    @PatchMapping(path = "/notice/big/{idPlayer}")
    public ResponseEntity<List<Player>> biggerNotice(@PathVariable Integer idPlayer) {
        return ResponseEntity.ok(paymentService.bigNotice(idPlayer));
    }

}
