package com.matsu.ebancoimobiliario.repository;

import com.matsu.ebancoimobiliario.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
