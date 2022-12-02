package com.wju.job_portal.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "job_skills")
public class JobSkills implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "job_skills_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobSkillsId;


    @Column(name = "skills")
    private String skills;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="job_id",nullable=false)
    private JobListings jobListings;

    public void setJobSkillsId(Integer jobSkillsId) {
        this.jobSkillsId = jobSkillsId;
    }

    public Integer getJobSkillsId() {
        return jobSkillsId;
    }


    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getSkills() {
        return skills;
    }

    public JobListings getJobListings() {
        return jobListings;
    }

    public void setJobListings(JobListings jobListings) {
        this.jobListings = jobListings;
    }

    @Override
    public String toString() {
        return "JobSkills{" +
                "jobSkillsId=" + jobSkillsId + '\'' +
                "skills=" + skills + '\'' +
                '}';
    }
}
