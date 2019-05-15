package com.gangofconnectfour.powerfourservice.repository;

import com.gangofconnectfour.powerfourservice.model.AuthData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthDataRepository extends JpaRepository<AuthData, Long> {
}
