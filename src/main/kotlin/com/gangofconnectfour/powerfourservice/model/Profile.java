package com.gangofconnectfour.powerfourservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profile")
public class Profile {

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "level")
    private Integer level;

    @Column(name = "score")
    private Double score;

}
