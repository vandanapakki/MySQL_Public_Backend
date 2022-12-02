package com.wju.job_portal.controller;

import com.wju.job_portal.entity.*;
import com.wju.job_portal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class HealthController {

    private UserTypeRepository userTypeRepository;
    private UsersRepository usersRepository;
    private JobListingsRepository jobListingsRepository;

    private CompanyRepository companyRepository;
    private ApplicationsRepository applicationsRepository;

    @Autowired
    HealthController(UserTypeRepository userTypeRepository, UsersRepository usersRepository,
                     JobListingsRepository jobListingsRepository, CompanyRepository companyRepository,
                     ApplicationsRepository applicationsRepository) {
        this.userTypeRepository = userTypeRepository;
        this.usersRepository = usersRepository;
        this.jobListingsRepository = jobListingsRepository;
        this.companyRepository = companyRepository;
        this.applicationsRepository = applicationsRepository;
    }

    @GetMapping("health")
    String health() {
        return "OK";
    }

    @GetMapping("test")
    UserType test() {
        UserType userType = userTypeRepository.getByUserTypeId(2);
        return userType;
    }

    @GetMapping("test1")
    String test1() {
        //Users user = usersRepository.getByUserId(1);
        //Users user = usersRepository.getByEmail("Alexa@gmail.com");
        List<Users> users = usersRepository.findAll();
        return users.get(1).getUsername();
    }

    @GetMapping("test2")
    int test2() {
        //Users user = usersRepository.getByUserId(1);
        //Users user = usersRepository.getByEmail("Alexa@gmail.com");
        List<JobListings> listings = jobListingsRepository.findAll();
        return listings.size();
    }

    @GetMapping("test3")
    int test3() {
        //Users user = usersRepository.getByUserId(1);
        //Users user = usersRepository.getByEmail("Alexa@gmail.com");
        List<JobListings> listings = companyRepository.getById(1).getJobListings().stream().toList();
        return listings.size();
    }

    @GetMapping("test4")
    int test4() {
        //Users user = usersRepository.getByUserId(1);
        //Users user = usersRepository.getByEmail("Alexa@gmail.com");
        Set<UserSkills> skills = usersRepository.getById(1).getUserSkillsSet();
        return skills.size();
    }

    // number of applications
    @GetMapping("test5")
    int test5() {
        //Users user = usersRepository.getByUserId(1);
        //Users user = usersRepository.getByEmail("Alexa@gmail.com");
        Set<Applications> applicationsOfUser = usersRepository.getById(1).getApplications();
        return applicationsOfUser.size();
    }
    // getAllByJobId

    @GetMapping("test6")
    int test6() {
        //Users user = usersRepository.getByUserId(1);
        //Users user = usersRepository.getByEmail("Alexa@gmail.com");
        Set<Applications> allApplications = applicationsRepository.getAllApplicationsForAJobId(1);
        return allApplications.size();
    }

    @GetMapping("test7")
    int test7() {
        //Users user = usersRepository.getByUserId(1);
        //Users user = usersRepository.getByEmail("Alexa@gmail.com");
        Set<Users> companies = usersRepository.getAllUserOfSpecificType(2);
        return companies.size();
    }
}
