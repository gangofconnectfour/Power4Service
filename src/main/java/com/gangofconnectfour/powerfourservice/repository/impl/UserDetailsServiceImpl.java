package com.gangofconnectfour.powerfourservice.repository.impl;

import com.gangofconnectfour.powerfourservice.model.User;
import com.gangofconnectfour.powerfourservice.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    public UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userFounded = this.userRepository.getUserByMail(s);
        if (userFounded == null)
            throw new UsernameNotFoundException(s);
        return new org.springframework.security.core.userdetails.User(userFounded.getEmail(), userFounded.getPassword(), Collections.emptyList());
    }
}
