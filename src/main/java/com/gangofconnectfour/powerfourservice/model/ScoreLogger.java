package com.gangofconnectfour.powerfourservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "score_logger")
public class ScoreLogger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid")
    private Long uuid;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "nb_turn")
    private Integer nbTurn;

    @Column(name = "winner_id")
    private Long winnerId;

    public ScoreLogger(Long duration, Integer nbTurn, Long winnerId) {
        this.duration = duration;
        this.nbTurn = nbTurn;
        this.winnerId = winnerId;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Integer getNbTurn() {
        return nbTurn;
    }

    public void setNbTurn(Integer nbTurn) {
        this.nbTurn = nbTurn;
    }

    public Long getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }
}
