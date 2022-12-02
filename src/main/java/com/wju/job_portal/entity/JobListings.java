package com.wju.job_portal.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "job_listings")
public class JobListings implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "job_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "job_location")
    private String jobLocation;

    @Column(name = "benefits")
    private String benefits;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "job_create")
    private Date jobCreate;

    @Column(name = "job_end")
    private Date jobEnd;

    @Column(name = "created_by")
    private Integer createdBy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="company_id", nullable=false)
    private Company company;

    @OneToMany(mappedBy = "jobListings", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<JobSkills> jobSkillsSet;

    @OneToMany(mappedBy = "jobListings", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Applications> applications;


    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setJobCreate(Date jobCreate) {
        this.jobCreate = jobCreate;
    }

    public Date getJobCreate() {
        return jobCreate;
    }

    public void setJobEnd(Date jobEnd) {
        this.jobEnd = jobEnd;
    }

    public Date getJobEnd() {
        return jobEnd;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<JobSkills> getJobSkillsSet() {
        return jobSkillsSet;
    }

    public void setJobSkillsSet(Set<JobSkills> jobSkillsSet) {
        this.jobSkillsSet = jobSkillsSet;
    }

    public Set<Applications> getApplications() {
        return applications;
    }

    public void setApplications(Set<Applications> applications) {
        this.applications = applications;
    }

    @Override
    public String toString() {
        return "JobListings{" +
                "jobId=" + jobId + '\'' +
                "jobTitle=" + jobTitle + '\'' +
                "jobDescription=" + jobDescription + '\'' +
                "jobLocation=" + jobLocation + '\'' +
                "benefits=" + benefits + '\'' +
                "salary=" + salary + '\'' +
                "jobCreate=" + jobCreate + '\'' +
                "jobEnd=" + jobEnd + '\'' +
                "createdBy=" + createdBy + '\'' +
                '}';
    }
}
