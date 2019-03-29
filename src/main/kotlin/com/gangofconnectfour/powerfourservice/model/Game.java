package com.gangofconnectfour.powerfourservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "game")
@Data
public class Game {

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdAt;


}
