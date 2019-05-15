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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uudi")
    private Long uuid;

    @Column(name = "ai_dificulty")
    private Integer aiDificulty;

    @OneToOne
    private Game game;

    @OneToOne
    private ScoreLogger scoreLogger;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Integer getAiDificulty() {
        return aiDificulty;
    }

    public void setAiDificulty(Integer aiDificulty) {
        this.aiDificulty = aiDificulty;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public ScoreLogger getScoreLogger() {
        return scoreLogger;
    }

    public void setScoreLogger(ScoreLogger scoreLogger) {
        this.scoreLogger = scoreLogger;
    }
}
