package com.gangofconnectfour.powerfourservice.repository.impl;

import com.gangofconnectfour.powerfourservice.model.MultiGame;
import com.gangofconnectfour.powerfourservice.repository.MultiGameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MultiGameService {

    private MultiGameRepository multiGameRepository;

    public MultiGameService(MultiGameRepository multiGameRepository) {
        this.multiGameRepository = multiGameRepository;
    }

    @Transactional
    public MultiGame findById(Long id){
        return multiGameRepository.findById(id).get();
    }

    @Transactional
    public MultiGame save(MultiGame game){
        return multiGameRepository.save(game);
    }

    @Transactional
    public List<MultiGame> findAll(){
        return multiGameRepository.findAll();
    }
}
