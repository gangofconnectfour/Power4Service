package com.gangofconnectfour.powerfourservice.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gangofconnectfour.powerfourservice.api.in.LoginDtoIn;
import com.gangofconnectfour.powerfourservice.configuration.SecurityDataConfig;
import com.gangofconnectfour.powerfourservice.model.User;
import com.gangofconnectfour.powerfourservice.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private SecurityDataConfig securityDataConfig;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, UserRepository userRepository, SecurityDataConfig securityDataConfig) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.securityDataConfig = securityDataConfig;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            LoginDtoIn creds = new ObjectMapper()
                    .readValue(req.getInputStream(), LoginDtoIn.class);

            User userFinded = userRepository.getUserByMail(creds.getMail());

            if (Boolean.FALSE.equals(userFinded.getUserWS())) {
                return authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                creds.getMail(),
                                creds.getPassword()));
            }

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getMail(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String token = JWT.create()
                .withSubject(auth.getPrincipal().toString())
                .withExpiresAt(new Date(System.currentTimeMillis() + securityDataConfig.getExpirationTime()))
                .sign(Algorithm.HMAC512(securityDataConfig.getSecret().getBytes()));
        res.addHeader(securityDataConfig.getHeaderString(), securityDataConfig.getTokenPrefix() + token);
    }
}