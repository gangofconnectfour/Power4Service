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
    @Column(name = "uuid")
    private String uuid;

    @OneToOne
    private Game game;

    @OneToOne
    private ScoreLogger scoreLogger;

}
