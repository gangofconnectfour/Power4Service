package com.gangofconnectfour.powerfourservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @Column(name = "uuid")
    private String uuid;

    @OneToMany(orphanRemoval = true)
    private List<AuthData> auths;

    @OneToOne(orphanRemoval = true)
    private Profile profile;

    @OneToMany(orphanRemoval = true)
    private List<SoloGame> soloGames;

    @OneToMany(orphanRemoval = true)
    private List<MultiGame> multiGames;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "create_at", updatable = false)
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

}
