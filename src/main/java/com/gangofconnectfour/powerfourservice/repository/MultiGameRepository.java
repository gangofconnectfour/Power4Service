package com.gangofconnectfour.powerfourservice.repository;

import com.gangofconnectfour.powerfourservice.model.MultiGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultiGameRepository extends JpaRepository<MultiGame, Long> {
}
