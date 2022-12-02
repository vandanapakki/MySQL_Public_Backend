package com.wju.job_portal.repository;

import com.wju.job_portal.entity.Applications;
import com.wju.job_portal.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;


public interface UsersRepository extends JpaRepository<Users, Integer> {

    String USER_OF_SPECIFIC_TYPE = "select * from job_portal.users where user_type_id = :userTypeId";


    @Query(value = USER_OF_SPECIFIC_TYPE, nativeQuery = true)
    Set<Users> getAllUserOfSpecificType(@Param("userTypeId") int userTypeId);


    Users findByEmail(String email);


}