package com.gangofconnectfour.powerfourservice.repository.impl;

import com.gangofconnectfour.powerfourservice.model.SoloGame;
import com.gangofconnectfour.powerfourservice.repository.SoloGameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SoloGameService {

    private SoloGameRepository soloGameRepository;

    public SoloGameService(SoloGameRepository soloGameRepository) {
        this.soloGameRepository = soloGameRepository;
    }

    @Transactional
    public SoloGame findById(Long id){
        return soloGameRepository.findById(id).get();
    }

    @Transactional
    public SoloGame save(SoloGame game){
        return soloGameRepository.save(game);
    }

    @Transactional
    public List<SoloGame> findAll(){
        return soloGameRepository.findAll();
    }
}
