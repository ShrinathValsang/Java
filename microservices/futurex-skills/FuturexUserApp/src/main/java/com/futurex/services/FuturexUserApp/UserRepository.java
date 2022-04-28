package com.futurex.services.FuturexUserApp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface UserRepository extends JpaRepository<User, BigInteger> {
    List<User> getUsersByUserid(BigInteger userid);

    List<User> getUsersByCourseid(BigInteger courseid);
}
