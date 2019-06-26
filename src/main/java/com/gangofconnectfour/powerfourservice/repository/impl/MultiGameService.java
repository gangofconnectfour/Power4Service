package com.gangofconnectfour.powerfourservice.repository.impl;

import com.gangofconnectfour.powerfourservice.model.MultiGame;
import com.gangofconnectfour.powerfourservice.repository.MultiGameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultiGameService {

    private MultiGameRepository multiGameRepository;

    public MultiGameService(MultiGameRepository multiGameRepository) {
        this.multiGameRepository = multiGameRepository;
    }

    public MultiGame findById(Long id){
        return multiGameRepository.findById(id).get();
    }

    public MultiGame save(MultiGame game){
        return multiGameRepository.save(game);
    }

    public List<MultiGame> findAll(){
        return multiGameRepository.findAll();
    }
}
