package com.gangofconnectfour.powerfourservice.repository

import com.gangofconnectfour.powerfourservice.model.ScoreLogger
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ScoreLoggerRepository : JpaRepository<ScoreLogger, String> {
}