package com.gangofconnectfour.powerfourservice.repository.impl;

import com.gangofconnectfour.powerfourservice.model.AuthData;
import com.gangofconnectfour.powerfourservice.repository.AuthDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthDataService {

    private AuthDataRepository authDataRepository;

    public AuthDataService(AuthDataRepository authDataRepository) {
        this.authDataRepository = authDataRepository;
    }

    @Transactional
    public AuthData findById(Long id){
        return authDataRepository.findById(id).get();
    }

    @Transactional
    public AuthData save(AuthData authData){
        return authDataRepository.save(authData);
    }

    @Transactional
    public List<AuthData> findAll(){
        return authDataRepository.findAll();
    }
}
