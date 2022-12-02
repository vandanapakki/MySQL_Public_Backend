package com.wju.job_portal.repository;

import com.wju.job_portal.entity.Company;
import com.wju.job_portal.entity.JobListings;
import com.wju.job_portal.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    String COMPANY_BY_NAME = "select * from company c where company_name = :companyName";

    @Query(value = COMPANY_BY_NAME, nativeQuery = true)
    Company getCompany(@Param("companyName") String companyName);

}