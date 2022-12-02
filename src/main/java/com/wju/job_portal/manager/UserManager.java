package com.wju.job_portal.manager;

import com.wju.job_portal.document.dto.LoginDTO;
import com.wju.job_portal.document.dto.UserDTO;
import com.wju.job_portal.entity.*;
import com.wju.job_portal.repository.ApplicationsRepository;
import com.wju.job_portal.repository.JobListingsRepository;
import com.wju.job_portal.repository.UserTypeRepository;
import com.wju.job_portal.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class UserManager {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private JobListingsRepository jobListingsRepository;

    @Autowired
    private ApplicationsRepository applicationsRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    public boolean check(LoginDTO loginDTO) throws Exception {
        Optional<Users> userOptional = Optional.of(userRepository.findByEmail(loginDTO.getEmail()));
        if(userOptional.isEmpty()) {
            log.error("There is no User with email " + loginDTO.getEmail());
            throw new Exception("No User Exist");
        }
        return userOptional.get().getPassword().equals(Base64.getEncoder().encodeToString(loginDTO.getPassword().getBytes()));
    }

    public UserDTO addUser(LoginDTO user) throws Exception {
        Users newUser = new Users();
        Users userPresent = userRepository.findByEmail(user.getEmail());
        if(userPresent != null) {
            throw new Exception("User exists");
        }
        newUser.setUsername(user.getEmail());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
        newUser.setUserTypeId(userTypeRepository.getByUserTypeId(1)); // Job Seeker
        newUser.setUserSkillsSet(null);
        newUser.setApplications(null);

        Users newUserSaved = userRepository.save(newUser);
        return new UserDTO(newUserSaved.getUserId(), newUserSaved.getEmail(), newUserSaved.getUsername());
    }

    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<Users> userList = userRepository.findAll();
        for(Users user: userList) {
            userDTOList.add(new UserDTO(user));
        }
        return userDTOList;
    }

    public UserDTO getUserById(int userId) throws Exception {
        Optional<Users> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            log.error("There is no User with id " + userId);
            throw new Exception("There is no User with id " + userId);
        }
        return new UserDTO(userOptional.get());
    }

    public UserDTO updateUser(Users updateUser, Users originalUser) {
        try {
            if(originalUser.getEmail() != null) {
                originalUser.setEmail(updateUser.getEmail());
            }
            if(originalUser.getUsername() != null) {
                originalUser.setUsername(updateUser.getUsername());
            }
            if(originalUser.getPassword() != null) {
                originalUser.setPassword(Base64.getEncoder().encodeToString(updateUser.getPassword().getBytes()));
            }
            if(originalUser.getUserSkillsSet() != null) {
                originalUser.setUserSkillsSet(updateUser.getUserSkillsSet());
            }
            if(originalUser.getApplications() != null) {
                originalUser.setApplications(updateUser.getApplications());
            }
            originalUser.setUserTypeId(userTypeRepository.getByUserTypeId(1)); // type id 1 is job seeker
            userRepository.save(originalUser);
            return new UserDTO(originalUser);
        } catch (Exception e) {
            log.error("Exception when update User " + originalUser.toString());
            return null;
        }
    }

    public void deleteUser(int targetId, int userId) throws Exception {
        Optional<Users> requestUserOptional = userRepository.findById(userId);
        if(requestUserOptional.isEmpty()) {
            throw new Exception("There is no User with id" + userId);
        } else {
            if(!(requestUserOptional.get().getUserTypeId().getUserType().equalsIgnoreCase("Admin"))) {
                throw new Exception("This user has no access to delete");
            } else {
                Optional<Users> originalUserOptional = userRepository.findById(targetId);
                if(originalUserOptional.isEmpty()) {
                    log.error("There is no User with id " + targetId);
                    throw new Exception("There is no User with id " + targetId);
                }
                userRepository.deleteById(targetId);
            }
        }
    }

    public List<UserDTO> getUserByPosition(int positionId) throws Exception {
        List<UserDTO> userDTOList = new ArrayList<>();
        Optional<JobListings> jobListingsOptional = jobListingsRepository.findById(positionId);
        if(jobListingsOptional.isEmpty()) {
            throw new Exception("There is no job listing with id: " + positionId);
        }
        for(Applications application: applicationsRepository.getAllApplicationsForAJobId(positionId)) {
            userDTOList.add(new UserDTO(userRepository.findById(application.getUsers().getUserId()).get()));
        }
        return userDTOList;
    }

    public List<String> getMatchedSkills(int userId, int positionId) throws Exception {
        List<String> matchedSkills = new ArrayList<>();
        Optional<JobListings> positionOptional = jobListingsRepository.findById(positionId);
        if(positionOptional.isEmpty()) {
            throw new Exception("There is no Position with id: " + positionId);
        }
        Optional<Users> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new Exception("There is no User with id" + userId);
        }
        Set<JobSkills> positionRequiredSkills = positionOptional.get().getJobSkillsSet();
        Set<UserSkills> userSkills = userOptional.get().getUserSkillsSet();

        for (JobSkills jobSkill: positionRequiredSkills ) {
            for(UserSkills userSkill: userSkills) {
                if(jobSkill.getSkills().equalsIgnoreCase(userSkill.getSkills())) {
                    matchedSkills.add(userSkill.getSkills());
                }
            }
        }

        return matchedSkills;
    }

    public void applyPosition(int userId, int positionId) throws Exception{
        Optional<JobListings> positionOptional = jobListingsRepository.findById(positionId);
        if(positionOptional.isEmpty()) {
            throw new Exception("There is no Position with id: " + positionId);
        }
        Optional<Users> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new Exception("There is no User with id: " + userId);
        }
        userOptional.get().getApplications().add(new Applications(positionOptional.get(), userOptional.get()));
        userRepository.save(userOptional.get());
        jobListingsRepository.save(positionOptional.get());
    }
}
