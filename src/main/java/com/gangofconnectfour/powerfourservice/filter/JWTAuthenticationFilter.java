package com.gangofconnectfour.powerfourservice.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gangofconnectfour.powerfourservice.api.in.LoginDtoIn;
import com.gangofconnectfour.powerfourservice.configuration.SecurityDataConfig;
import com.gangofconnectfour.powerfourservice.model.AuthData;
import com.gangofconnectfour.powerfourservice.model.User;
import com.gangofconnectfour.powerfourservice.repository.impl.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final int ONE_HOUR_MILLIS = 3_600_000;
    private AuthenticationManager authenticationManager;
    private UserService userService;
    private SecurityDataConfig securityDataConfig;
    private String token;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, UserService userService, SecurityDataConfig securityDataConfig, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.securityDataConfig = securityDataConfig;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            LoginDtoIn creds = new ObjectMapper()
                    .readValue(req.getInputStream(), LoginDtoIn.class);

            User userFinded = userService.getUserByMail(creds.getMail());

            if (Boolean.FALSE.equals(userFinded.getUserWS()) || !bCryptPasswordEncoder.matches(creds.getPassword(), userFinded.getPassword()))
                return authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                creds.getMail(),
                                creds.getPassword()));
            

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getMail(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
            generateToken(authentication);

            return authentication;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) {

        res.addHeader(securityDataConfig.getHeaderString(), securityDataConfig.getTokenPrefix() + token);
    }

    private void generateToken(Authentication auth){
        this.token = JWT.create()
                .withSubject(auth.getPrincipal().toString())
                .withExpiresAt(new Date(System.currentTimeMillis() + securityDataConfig.getExpirationTime()))
                .sign(Algorithm.HMAC512(securityDataConfig.getSecret().getBytes()));
    }
}