package com.gangofconnectfour.powerfourservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "score_logger")
public class ScoreLogger {

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "nb_turn")
    private Integer nbTurn;

    @Column(name = "winner_id")
    private String winnerId;

}
