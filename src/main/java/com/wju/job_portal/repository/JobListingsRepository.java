package com.wju.job_portal.repository;

import com.wju.job_portal.entity.JobListings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Set;

public interface JobListingsRepository extends JpaRepository<JobListings, Integer> {

    String LISTINGS_BY_SALARY = "select * from job_portal.job_listings jl where salary =:salary";

    @Query(value = LISTINGS_BY_SALARY, nativeQuery = true)
    Set<JobListings> getAllListingsBySalary(@Param("salary") int salary);


    String LISTINGS_BY_POSTDATE = "select * from job_portal.job_listings where job_create = :date";

    @Query(value = LISTINGS_BY_POSTDATE, nativeQuery = true)
    Set<JobListings> getAllListingsByDate(@Param("date") Date date);

    String LISTINGS_BY_COMPANY = "select * from job_portal.job_listings where company_id = :companyID";

    @Query(value = LISTINGS_BY_COMPANY, nativeQuery = true)
    Set<JobListings> getAllListingsByCompany(@Param("companyID") int companyID);


    String LISTINGS_BY_DESCRIPTION = "select * from job_portal.job_listings job_description LIKE %:desc% ";
    @Query(value = LISTINGS_BY_DESCRIPTION, nativeQuery = true)
    Set<JobListings> getAllListingsByDescription(@Param("desc") String desc);

}