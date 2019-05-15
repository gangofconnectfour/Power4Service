package com.gangofconnectfour.powerfourservice.repository;

import com.gangofconnectfour.powerfourservice.model.SoloGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoloGameRepository extends JpaRepository<SoloGame, Long> {
}
