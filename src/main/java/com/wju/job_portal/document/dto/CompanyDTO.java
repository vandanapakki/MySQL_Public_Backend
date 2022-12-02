package com.wju.job_portal.document.dto;

import com.wju.job_portal.entity.Company;
import com.wju.job_portal.entity.JobListings;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.Position;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@NoArgsConstructor
public class CompanyDTO {
    private String id;
    private String name;
    private Set<String> jobListings = new HashSet<>();

    public CompanyDTO(Company company) {
        this.id = company.getCompanyId().toString();
        this.name = company.getCompanyName();

        Set<String> listings = new HashSet<>();
        for (JobListings jobListings: company.getJobListings()) {
            listings.add(jobListings.getJobTitle());
        }
        this.jobListings = listings;
    }

    public CompanyDTO(int companyId, String companyName) {
        this.id = String.valueOf(companyId);
        this.name = companyName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getJobListings() {
        return jobListings;
    }

    public void setJobListings(Set<String> jobListings) {
        this.jobListings = jobListings;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
