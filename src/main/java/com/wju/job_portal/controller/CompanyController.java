package com.wju.job_portal.controller;

import com.wju.job_portal.document.dto.CompanyDTO;
import com.wju.job_portal.document.dto.LoginDTO;
import com.wju.job_portal.entity.Company;
import com.wju.job_portal.manager.CompanyManager;
import com.wju.job_portal.repository.CompanyRepository;
import com.wju.job_portal.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping(value = "/v1")
public class CompanyController {

    @Autowired
    private CompanyManager companyManager;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CompanyRepository companyRepository;

    //login
    @PostMapping(value = "/loginCompany")
    public ResponseEntity<Boolean> loginCompany(@RequestBody LoginDTO loginDTO) {
        try{
            Boolean result = companyManager.checkCompany(loginDTO);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception when Company login: {} ", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //create a company
    @PostMapping(value = "/postCompany")
    public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO company) {
        try {
            return new ResponseEntity<>(companyManager.addCompany(company), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception when create a new Company: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get all companies
    @GetMapping(value = "/getAllCompanies")
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        try {
            return new ResponseEntity<>(companyManager.getAllCompanies(), HttpStatus.OK);
        } catch(Exception e) {
            log.error("Exception when get all Companies: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get company by id
    @GetMapping(value = "/getCompany/{id}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable String id) {
        try {
            Optional<Company> companyOptional = companyRepository.findById(Integer.parseInt(id));
            if(companyOptional.isEmpty()) {
                log.error("There is no Company with id " + id);
                throw new Exception("There is no Company with id " + id);
            }
            return new ResponseEntity<>(new CompanyDTO(companyOptional.get()), HttpStatus.OK);
        } catch(Exception e) {
            log.error("Exception when create a new Company: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update a Company by id
//    @PutMapping(value = "/updateCompany/{id}")
//    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable String id, @RequestBody Users updateCompany) {
//        try{
//            Optional<Users> originalCompanyOptional = usersRepository.findById(Integer.parseInt(id));
//            if(originalCompanyOptional.isEmpty() || !originalCompanyOptional.get().getUserTypeId().getUserType().equalsIgnoreCase("Jobprovider")) {
//                log.error("There is no Company with id " + id);
//                throw new Exception("There is no Company with id " + id);
//            }
//            return new ResponseEntity<>(companyManager.updateCompany(updateCompany, originalCompanyOptional.get()), HttpStatus.OK);
//        } catch (Exception e) {
//            log.error("Exception when update Company: {} ", e.getMessage());
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    //delete a Company by id
    @DeleteMapping(value = "/deleteCompany/{targetId}/{userId}")
    public ResponseEntity<String> deleteApplicantById(@PathVariable String targetId, @PathVariable String userId) {
        try {
            companyManager.deleteCompany(Integer.parseInt(targetId), Integer.parseInt(userId));
            return new ResponseEntity<>("Company was deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception when delete Company: {} ", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}


