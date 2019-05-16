package com.gangofconnectfour.powerfourservice.repository;

import com.gangofconnectfour.powerfourservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User u where u.email = :mail")
    User getUserByMail(String mail);

    User findByUuid(Long uuid);
}
