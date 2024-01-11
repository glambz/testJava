package com.test.testjava.dao;

import com.test.testjava.dto.UserDetailDTO;
import com.test.testjava.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
    @Query("""
        SELECT new com.test.testjava.dto.UserDetailDTO(ud.firstName)
        FROM UserDetail ud
        WHERE ud.user.id = :val
    """)
    UserDetailDTO getDetailByUserId(@Param("val")long id);
}