package com.gangofconnectfour.powerfourservice.repository.impl

import com.gangofconnectfour.powerfourservice.repository.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(applicationUserRepository : UserRepository) : UserDetailsService {

    var applicationUserRepository = applicationUserRepository

    override fun loadUserByUsername(username: String?): UserDetails {
        var applicationUser = applicationUserRepository.getUserByMail(username!!);
        if (applicationUser == null) {
            throw UsernameNotFoundException(username)
        }
        return org.springframework.security.core.userdetails.User(applicationUser.email, applicationUser.password, emptyList<GrantedAuthority>())
    }
}