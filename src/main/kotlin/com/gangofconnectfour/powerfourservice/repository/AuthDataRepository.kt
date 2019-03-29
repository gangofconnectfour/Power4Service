package com.gangofconnectfour.powerfourservice.repository

import com.gangofconnectfour.powerfourservice.model.AuthData
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthDataRepository : JpaRepository<AuthData, String> {
}