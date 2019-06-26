package com.gangofconnectfour.powerfourservice.repository.impl;

import com.gangofconnectfour.powerfourservice.model.User;
import com.gangofconnectfour.powerfourservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {return userRepository.findAll();}

    public User getUserByMail(String mail){
        return userRepository.getUserByMail(mail);
    }

    public User findByUuid(Long uuid){
        return userRepository.findByUuid(uuid);
    }
}
