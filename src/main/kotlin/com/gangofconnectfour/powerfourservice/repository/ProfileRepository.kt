package com.gangofconnectfour.powerfourservice.repository

import com.gangofconnectfour.powerfourservice.model.Profile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProfileRepository : JpaRepository<Profile, Long> {
}