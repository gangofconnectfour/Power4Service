package com.gangofconnectfour.powerfourservice.repository

import com.gangofconnectfour.powerfourservice.model.Game
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GameRepository : JpaRepository<Game, Long> {
}