package com.wju.job_portal.document.dto;

import com.wju.job_portal.entity.Applications;
import com.wju.job_portal.entity.Company;
import com.wju.job_portal.entity.JobListings;
import com.wju.job_portal.entity.JobSkills;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class PositionDTO {

    private Integer jobId;

    private String jobTitle;

    private String jobDescription;

    private String jobLocation;

    private String benefits;

    private Integer salary;

    private Date jobCreate;

    private Date jobEnd;

    private Integer createdBy;

    private String company;

    private Set<String> jobSkillsSet = new HashSet<>();

    private Set<String> applications = new HashSet<>();

    public PositionDTO(int jobId, String jobTitle) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
    }

    public PositionDTO(JobListings listing) {
        this.jobId = listing.getJobId();
        this.jobTitle = listing.getJobTitle();
        this.benefits = listing.getBenefits();
        this.jobDescription = listing.getJobDescription();
        this.jobLocation = listing.getJobLocation();
        this.salary = listing.getSalary();
        this.jobCreate = listing.getJobCreate();
        this.jobEnd = listing.getJobEnd();
        this.createdBy = listing.getCreatedBy();
        this.company = listing.getCompany().getCompanyName();

        Set<String> jobSkills = new HashSet<>();
        for (JobSkills skills: listing.getJobSkillsSet()) {
            jobSkills.add(skills.getSkills());
        }
        this.jobSkillsSet = jobSkills;

        Set<String> jobApplications = new HashSet<>();
        for (Applications userApplications: listing.getApplications()) {
            jobApplications.add(userApplications.getUsers().getUsername());
        }
        this.applications = jobApplications;
    }


    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getJobCreate() {
        return jobCreate;
    }

    public void setJobCreate(Date jobCreate) {
        this.jobCreate = jobCreate;
    }

    public Date getJobEnd() {
        return jobEnd;
    }

    public void setJobEnd(Date jobEnd) {
        this.jobEnd = jobEnd;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Set<String> getJobSkillsSet() {
        return jobSkillsSet;
    }

    public void setJobSkillsSet(Set<String> jobSkillsSet) {
        this.jobSkillsSet = jobSkillsSet;
    }

    public Set<String> getApplications() {
        return applications;
    }

    public void setApplications(Set<String> applications) {
        this.applications = applications;
    }
}
