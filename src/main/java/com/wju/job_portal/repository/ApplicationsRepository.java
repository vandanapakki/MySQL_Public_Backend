package com.wju.job_portal.repository;

import com.wju.job_portal.entity.Applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ApplicationsRepository extends JpaRepository<Applications, Integer> {

    String APPLICATION_BY_USER = "select * from job_portal.applications where job_id = :jobID";

    @Query(value = APPLICATION_BY_USER, nativeQuery = true)
    Set<Applications> getAllApplicationsForAJobId(@Param("jobID") int jobID);

}