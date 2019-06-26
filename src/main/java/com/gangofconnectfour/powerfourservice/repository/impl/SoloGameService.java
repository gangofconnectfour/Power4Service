package com.gangofconnectfour.powerfourservice.repository.impl;

import com.gangofconnectfour.powerfourservice.model.SoloGame;
import com.gangofconnectfour.powerfourservice.repository.SoloGameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoloGameService {

    private SoloGameRepository soloGameRepository;

    public SoloGameService(SoloGameRepository soloGameRepository) {
        this.soloGameRepository = soloGameRepository;
    }

    public SoloGame findById(Long id){
        return soloGameRepository.findById(id).get();
    }

    public SoloGame save(SoloGame game){
        return soloGameRepository.save(game);
    }

    public List<SoloGame> findAll(){
        return soloGameRepository.findAll();
    }
}
