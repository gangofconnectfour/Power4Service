package com.gangofconnectfour.powerfourservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "connected_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date connectedAt;

    @Column(name = "expired_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredAt;

}
