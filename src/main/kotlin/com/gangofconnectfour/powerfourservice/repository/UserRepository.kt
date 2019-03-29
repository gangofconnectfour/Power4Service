package com.gangofconnectfour.powerfourservice.repository

import com.gangofconnectfour.powerfourservice.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String> {
}