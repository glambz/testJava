package com.test.testjava.dao;

import com.test.testjava.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("""
        SELECT u.id FROM User u WHERE u.username = :val
    """)
    public Long findIdByUsername(@Param("val")String username);
}