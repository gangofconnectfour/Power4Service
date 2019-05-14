package com.gangofconnectfour.powerfourservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gangofconnectfour.powerfourservice.api.in.UserDtoIn;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "create_at", updatable = false)
    private LocalDateTime createAt;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @Column(name = "user_ws")
    private Boolean userWS = Boolean.FALSE;

    public User(UserDtoIn dtoIn){
        this.uuid = UUID.randomUUID().toString();
        this.email = dtoIn.getEmail();
        this.password = dtoIn.getEncryptedPass();
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    public User(String email, String password) {
        this.uuid = UUID.randomUUID().toString();
        this.email = email;
        this.password = password;
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
        this.userWS = Boolean.TRUE;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<AuthData> getAuths() {
        return auths;
    }

    public void setAuths(List<AuthData> auths) {
        this.auths = auths;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<SoloGame> getSoloGames() {
        return soloGames;
    }

    public void setSoloGames(List<SoloGame> soloGames) {
        this.soloGames = soloGames;
    }

    public List<MultiGame> getMultiGames() {
        return multiGames;
    }

    public void setMultiGames(List<MultiGame> multiGames) {
        this.multiGames = multiGames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public Boolean getUserWS() {
        return userWS;
    }

    public void setUserWS(Boolean userWS) {
        this.userWS = userWS;
    }
}
