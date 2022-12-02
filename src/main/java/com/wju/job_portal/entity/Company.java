package com.wju.job_portal.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "company_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyId;

    @Column(name = "company_name")
    private String companyName;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<JobListings> jobListings;


    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Set<JobListings> getJobListings() {
        return jobListings;
    }

    public void setJobListings(Set<JobListings> jobListings) {
        this.jobListings = jobListings;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId + '\'' +
                "companyname=" + companyName + '\'' +
                '}';
    }
}
