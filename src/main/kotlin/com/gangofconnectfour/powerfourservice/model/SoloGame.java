package com.gangofconnectfour.powerfourservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "solo_game")
public class SoloGame {

    @Id
    @Column(name = "uudi")
    private String uuid;

    @Column(name = "ai_dificulty")
    private Integer aiDificulty;

    @OneToOne
    private Game game;

    @OneToOne
    private ScoreLogger scoreLogger;


}
