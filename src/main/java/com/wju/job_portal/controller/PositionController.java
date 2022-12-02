package com.wju.job_portal.controller;

import com.wju.job_portal.document.dto.CompanyDTO;
import com.wju.job_portal.document.dto.PositionDTO;
import com.wju.job_portal.entity.Company;
import com.wju.job_portal.entity.JobListings;
import com.wju.job_portal.manager.PositionManager;
import com.wju.job_portal.repository.CompanyRepository;
import com.wju.job_portal.repository.JobListingsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.Instant;
import java.util.*;

@RestController
@Slf4j
@RequestMapping(value = "/v1")
public class PositionController {

    @Autowired
    private JobListingsRepository positionRepository;

    @Autowired
    private PositionManager positionManager;

    @Autowired
    private CompanyRepository companyRepository;

    //create a position
    @PostMapping(value = "/postPosition/{companyId}")
    public ResponseEntity<PositionDTO> createPosition(@RequestBody JobListings position, @PathVariable String companyId) {
        try{
            return new ResponseEntity<>(positionManager.addPosition(position, Integer.parseInt(companyId)), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception when create a new Position: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get all positions
    @GetMapping(value = "/getAllPositions")
    public ResponseEntity<List<PositionDTO>> getAllPositions() {
        try {
            List<JobListings> positions = positionRepository.findAll();
            List<PositionDTO> positionDTOList = new ArrayList<>();
            for(JobListings position: positions) {
                positionDTOList.add(new PositionDTO(position));
            }
            return new ResponseEntity<>(positionDTOList, HttpStatus.OK);
        } catch(Exception e) {
            log.error("Exception when get all Positions: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get position by id
    @GetMapping(value = "/getPosition/{id}")
    public ResponseEntity<PositionDTO> getPositionById(@PathVariable String id) {
        try {
            Optional<JobListings> positionOptional = positionRepository.findById(Integer.parseInt(id));
            if(positionOptional.isEmpty()) {
                log.error("There is no Position with id " + id);
                throw new Exception("There is no Position with id " + id);
            }
            return new ResponseEntity<>(new PositionDTO(positionOptional.get()), HttpStatus.OK);
        } catch(Exception e) {
            log.error("Exception when create a new Position: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get positions by description
    @GetMapping(value = "/getPositionByDescription/{description}")
    public ResponseEntity<Set<JobListings>> getPositionsByDescription(@PathVariable String description) {
        try {
            Set<JobListings> positionList = positionRepository.getAllListingsByDescription(description);
            return new ResponseEntity<>(positionList, HttpStatus.OK);
        } catch(Exception e) {
            log.error("Exception when get Position by description: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get positions by postDate
    @GetMapping(value = "/getPositionByPostDate/{postDate}")
    public ResponseEntity<Set<PositionDTO>> getPositionsByPostDate(@PathVariable Instant postDate) {
        try {
            Instant now = Instant.now();
            Date current = (Date) Date.from(now);
            Set<JobListings> positionList = positionRepository.getAllListingsByDate(current);
            Set<PositionDTO> positionDTOList = new HashSet<>();
            for(JobListings position: positionList) {
                positionDTOList.add(new PositionDTO(position));
            }
            return new ResponseEntity<>(positionDTOList, HttpStatus.OK);
        } catch(Exception e) {
            log.error("Exception when get Position by Post Date: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get positions by salary
    @GetMapping(value = "/getPositionBySalary/{salary}")
    public ResponseEntity<Set<PositionDTO>> getPositionsBySalary(@PathVariable int salary) {
        try {
            Set<JobListings> positionList = positionRepository.getAllListingsBySalary(salary);
            Set<PositionDTO> positionDTOList = new HashSet<>();
            for(JobListings position: positionList) {
                positionDTOList.add(new PositionDTO(position));
            }
            return new ResponseEntity<>(positionDTOList, HttpStatus.OK);
        } catch(Exception e) {
            log.error("Exception when get Position by Salary: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get positions by company
    @GetMapping(value = "/getPositionByCompany/{companyName}")
    public ResponseEntity<Set<PositionDTO>> getPositionsByCompany(@PathVariable String companyName) {
        try {
            Company company = companyRepository.getCompany(companyName);
            Set<JobListings> positionList = positionRepository.getAllListingsByCompany(company.getCompanyId());
            Set<PositionDTO> positionDTOList = new HashSet<>();
            for(JobListings position: positionList) {
                positionDTOList.add(new PositionDTO(position));
            }
            return new ResponseEntity<>(positionDTOList, HttpStatus.OK);
        } catch(Exception e) {
            log.error("Exception when get Position by Company: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //update a position by id
    @PutMapping(value = "/updatePosition/{id}")
    public ResponseEntity<PositionDTO> updatePosition(@PathVariable String id, @RequestBody JobListings updatePosition) {
        try{
            Optional<JobListings> originalPositionOptional = positionRepository.findById(Integer.parseInt(id));
            if(originalPositionOptional.isEmpty()) {
                log.error("There is no Position with id " + id);
                throw new Exception("There is no Position with id " + id);
            }
            JobListings updatedPosition = positionManager.updatePosition(updatePosition, originalPositionOptional.get());
            return new ResponseEntity<>(new PositionDTO(updatedPosition), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception when update Position: {} ", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //delete a position by id
    @DeleteMapping(value = "/deletePosition/{id}")
    public ResponseEntity<String> deletePositionById(@PathVariable String id) {
        try {
            Optional<JobListings> originalPositionOptional = positionRepository.findById(Integer.parseInt(id));
            if(originalPositionOptional.isEmpty()) {
                log.error("There is no Position with id " + id);
                throw new Exception("There is no Position with id " + id);
            }
            positionRepository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>("Position was deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception when delete Position: {} ", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
