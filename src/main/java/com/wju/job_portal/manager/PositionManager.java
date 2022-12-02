package com.wju.job_portal.manager;

import com.wju.job_portal.document.dto.PositionDTO;
import com.wju.job_portal.entity.Company;
import com.wju.job_portal.entity.JobListings;
import com.wju.job_portal.repository.CompanyRepository;
import com.wju.job_portal.repository.JobListingsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.Optional;

@Service
@Slf4j
public class PositionManager {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private JobListingsRepository jobListingsRepository;



    public PositionDTO addPosition(JobListings position, int companyId) throws Exception {
        Optional<Company> originalCompanyOptional = companyRepository.findById(companyId);
        if(originalCompanyOptional.isEmpty()) {
            log.error("There is no Company with id " + companyId);
            throw new Exception("There is no Company with id " + companyId);
        }

        Instant now = Instant.now();
        Date current = (Date) Date.from(now);

        position.setJobCreate(current);
        JobListings newPosition = jobListingsRepository.save(position);

        return new PositionDTO(newPosition.getJobId(), newPosition.getJobTitle());
    }

    public JobListings updatePosition(JobListings updatePosition, JobListings originalPosition) {
        JobListings listing = null;
        try {
            if(updatePosition.getJobTitle() != null) {
                originalPosition.setJobTitle(updatePosition.getJobTitle());
            }
            if(updatePosition.getJobDescription() != null) {
                originalPosition.setJobDescription(updatePosition.getJobDescription());
            }
            if(updatePosition.getJobLocation() != null) {
                originalPosition.setJobLocation(updatePosition.getJobLocation());
            }
            if(updatePosition.getBenefits() != null) {
                originalPosition.setBenefits(updatePosition.getBenefits());
            }
            if(updatePosition.getSalary() != 0) {
                originalPosition.setSalary(updatePosition.getSalary());
            }
            if(updatePosition.getJobEnd() != null) {
                originalPosition.setJobEnd(updatePosition.getJobEnd());
            }
            if(updatePosition.getCreatedBy() != null) {
                originalPosition.setCreatedBy(updatePosition.getCreatedBy());
            }
            if(updatePosition.getJobSkillsSet() != null) {
                originalPosition.setJobSkillsSet(updatePosition.getJobSkillsSet());
            }
//            if(updatePosition.get() != null) {
//                originalPosition.setCandidatesList(updatePosition.getCandidatesList());
//            }
            listing = jobListingsRepository.save(originalPosition);
        } catch (Exception e) {
            log.error("Exception when update Applicant " + originalPosition.toString());
        }
        return listing;
    }
}
