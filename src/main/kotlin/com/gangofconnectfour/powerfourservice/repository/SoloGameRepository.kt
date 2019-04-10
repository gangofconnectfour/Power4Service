package com.gangofconnectfour.powerfourservice.repository

import com.gangofconnectfour.powerfourservice.model.SoloGame
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SoloGameRepository : JpaRepository<SoloGame, String> {
}