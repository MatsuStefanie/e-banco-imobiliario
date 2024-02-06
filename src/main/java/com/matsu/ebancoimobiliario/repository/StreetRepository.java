package com.matsu.ebancoimobiliario.repository;

import com.matsu.ebancoimobiliario.domain.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends JpaRepository<Street, Integer> {
}
