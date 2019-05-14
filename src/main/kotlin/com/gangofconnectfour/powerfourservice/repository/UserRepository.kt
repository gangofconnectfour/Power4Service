package com.gangofconnectfour.powerfourservice.repository

import com.gangofconnectfour.powerfourservice.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository : JpaRepository<User, String> {

    @Query("from User u where u.email = :mail")
    fun getUserByMail(mail : String): User

    fun findByUuid(uuid : String) : User
}