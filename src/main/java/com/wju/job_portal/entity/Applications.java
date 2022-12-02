package com.wju.job_portal.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "applications")
public class Applications implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "application_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applicationId;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id",nullable=false)
    private Users users;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="job_id",nullable=false)
    private JobListings jobListings;

    public Applications (JobListings jobId, Users userId) {
        this.jobListings = jobId;
        this.users = userId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public JobListings getJobListings() {
        return jobListings;
    }

    public void setJobListings(JobListings jobListings) {
        this.jobListings = jobListings;
    }

    @Override
    public String toString() {
        return "Applications{" +
                "applicationId=" + applicationId + '\'' +
                '}';
    }
}
