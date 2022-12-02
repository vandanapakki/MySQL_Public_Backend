package com.wju.job_portal.manager;


import com.wju.job_portal.document.dto.CompanyDTO;
import com.wju.job_portal.document.dto.LoginDTO;
import com.wju.job_portal.document.dto.UserDTO;
import com.wju.job_portal.entity.Company;
import com.wju.job_portal.entity.Users;
import com.wju.job_portal.repository.CompanyRepository;
import com.wju.job_portal.repository.UserTypeRepository;
import com.wju.job_portal.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class CompanyManager {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    public boolean checkCompany(LoginDTO loginDTO) throws Exception {
        Optional<Users> userOptional = Optional.of(userRepository.findByEmail(loginDTO.getEmail()));
        if(userOptional.isEmpty() || userOptional.get().getUserTypeId().getUserType().equalsIgnoreCase("Jobprovider")) {
            log.error("There is no Company with email " + loginDTO.getEmail());
            throw new Exception("No Company Exist");
        }
        return userOptional.get().getPassword().equals(Base64.getEncoder().encodeToString(loginDTO.getPassword().getBytes()));
    }

    public CompanyDTO addCompany(CompanyDTO companyDTO) throws Exception {
        Optional<Company> companyOptional = Optional.of(companyRepository.getCompany(companyDTO.getName()));
        if(companyOptional.isPresent()) {
            throw new Exception("Company exists");
        }

        Company newCompany = new Company();
        newCompany.setCompanyName(companyDTO.getName());
        Company savedCompany = companyRepository.save(newCompany);
        return new CompanyDTO(savedCompany.getCompanyId(), savedCompany.getCompanyName());
    }

    public List<CompanyDTO> getAllCompanies() {
        List<CompanyDTO> companyDTOList = new ArrayList<>();
        List<Company> companyList = companyRepository.findAll();
        for(Company company: companyList) {
            companyDTOList.add(new CompanyDTO(company));
        }
        return companyDTOList;
    }


//    public CompanyDTO updateCompany(Users updateCompany, Users originalCompany) {
//        try {
//            if(updateCompany.getUsername() != null) {
//                originalCompany.setUsername(updateCompany.getUsername());
//            }
//            if(updateCompany.getEmail() != null) {
//                originalCompany.setEmail(updateCompany.getEmail());
//            }
//            if(updateCompany.getPassword() != null) {
//                originalCompany.setPassword(Base64.getEncoder().encodeToString(updateCompany.getPassword().getBytes()));
//            }
//            originalCompany.setUserTypeId(userTypeRepository.getByUserTypeId(2));
//
//            Users updatedCompany = userRepository.save(originalCompany);
//            return new CompanyDTO(updatedCompany.getUserId(), updatedCompany.getUsername());
//        } catch (Exception e) {
//            log.error("Exception when update Company " + originalCompany.toString());
//            return null;
//        }
//    }

    public void deleteCompany(int companyId, int userId) throws Exception {
        Optional<Users> requestUserOptional = userRepository.findById(userId);
        if(requestUserOptional.isEmpty()) {
            throw new Exception("There is no User with id" + userId);
        } else {
            if(!requestUserOptional.get().getUserTypeId().getUserType().equalsIgnoreCase("Admin")) {
                throw new Exception("This user has no access to delete");
            } else {
                Optional<Company> originalCompanyOptional = companyRepository.findById(companyId);
                if(originalCompanyOptional.isEmpty() ) {
                    log.error("There is no Company with id " + companyId);
                    throw new Exception("There is no Company with id " + companyId);
                }
                companyRepository.deleteById(companyId);
            }
        }
    }
}
