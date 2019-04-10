package com.gangofconnectfour.powerfourservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "auth")
public class AuthData {

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "token")
    private String token;

    @Column(name = "connected_at", updatable = false)
    private LocalDateTime connectedAt;

    @Column(name = "expired_at", updatable = false)
    private LocalDateTime expiredAt;

}
