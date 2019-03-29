package com.gangofconnectfour.powerfourservice.repository

import com.gangofconnectfour.powerfourservice.model.MultiGame
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MultiGameRepository : JpaRepository<MultiGame, String> {
}