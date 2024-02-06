package com.matsu.ebancoimobiliario.repository;

import com.matsu.ebancoimobiliario.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {
}
