package com.wju.job_portal.controller;

import com.wju.job_portal.document.dto.LoginDTO;
import com.wju.job_portal.document.dto.UserDTO;
import com.wju.job_portal.entity.Users;
import com.wju.job_portal.manager.UserManager;
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
public class UserController {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private UserManager userManager;

    //login
    @PostMapping(value = "/loginUser")
    public ResponseEntity<Boolean> loginUser(@RequestBody LoginDTO loginDTO) {
        try{
            Boolean result = userManager.check(loginDTO);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception when User login: {} ", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //create a user
    @PostMapping(value = "/postUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody LoginDTO loginDTO) {
        try{
            return new ResponseEntity<>(userManager.addUser(loginDTO), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception when create a new User: {} ", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //user apply for a position
    @PostMapping(value = "/apply/{userId}/{positionId}")
    public ResponseEntity<String> applyPosition(@PathVariable String userId, @PathVariable String positionId) {
        try {
            userManager.applyPosition(Integer.parseInt(userId), Integer.parseInt(positionId));
            return new ResponseEntity<>("User applied for the position successfully", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception when apply the position: {} ", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get all users
    @GetMapping(value = "/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        try {
            List<UserDTO> users  = userManager.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch(Exception e) {
            log.error("Exception when get all Users: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get user by id
    @GetMapping(value = "/getUser/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(userManager.getUserById(Integer.parseInt(id)), HttpStatus.OK);
        } catch(Exception e) {
            log.error("Exception when create a new User: {} ", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get users of a position applicant
    @GetMapping(value = "/getUserByPosition/{positionId}")
    public ResponseEntity<List<UserDTO>> getUserByCompany(@PathVariable String positionId) {
        try {
            List<UserDTO> userList = userManager.getUserByPosition(Integer.parseInt(positionId));
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception when get users by Position: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //return the matched skills
    @GetMapping(value = "/compareSkills/{userId}/{positionId}")
    public ResponseEntity<List<String>> compareSkills(@PathVariable String userId, @PathVariable String positionId) {
        try {
            List<String> skillsList = userManager.getMatchedSkills(Integer.parseInt(userId), Integer.parseInt(positionId));
            return new ResponseEntity<>(skillsList, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception when get matched skills: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update a user by id
    @PutMapping(value = "/updateUser/{id}")
    public ResponseEntity<UserDTO> updateApplicant(@PathVariable String id, @RequestBody Users updateUser) {
        try{
            Optional<Users> originalUserOptional = userRepository.findById(Integer.parseInt(id));
            if(originalUserOptional.isEmpty()) {
                log.error("There is no User with id " + id);
                throw new Exception("There is no User with id " + id);
            }
            return new ResponseEntity<>(userManager.updateUser(updateUser, originalUserOptional.get()), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception when update User: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //delete a user by id
    @DeleteMapping(value = "/deleteUser/{targetId}/{userId}")
    public ResponseEntity<String> deleteApplicantById(@PathVariable String targetId, @PathVariable String userId) {
        try {
            userManager.deleteUser(Integer.parseInt(targetId), Integer.parseInt(userId));
            return new ResponseEntity<>("User was deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception when delete User: {}", e.getMessage());
            return new ResponseEntity<>("User does not have admin rights to delete user",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
