package com.matsu.ebancoimobiliario.repository;

import com.matsu.ebancoimobiliario.domain.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StocksRepository extends JpaRepository<Stocks, Integer> {

}
