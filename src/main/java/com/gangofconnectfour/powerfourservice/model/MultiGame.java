package com.gangofconnectfour.powerfourservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "multi_game")
public class MultiGame {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid")
    private Long uuid;

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