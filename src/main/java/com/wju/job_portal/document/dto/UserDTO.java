package com.wju.job_portal.document.dto;

import com.wju.job_portal.entity.Applications;
import com.wju.job_portal.entity.UserSkills;
import com.wju.job_portal.entity.Users;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@NoArgsConstructor
public class UserDTO {

    private String id;
    private String email;
    private String name;
    private String password;
    private Set<String> skills = new HashSet<>();
    private Set<String> appliedPositions = new HashSet<>();

    public UserDTO(Users user) {
        this.id = user.getUserId().toString();
        this.email = user.getEmail();
        this.name = user.getUsername();

        HashSet<String> skillSet = new HashSet<>();
        for (UserSkills userSkill: user.getUserSkillsSet()) {
            skillSet.add(userSkill.getSkills());
        }
        this.skills = skillSet;

        HashSet<String> applicationsSet = new HashSet<>();
        for (Applications applications: user.getApplications()) {
            applicationsSet.add(applications.getJobListings().getJobTitle());
        }
        this.appliedPositions = applicationsSet;
    }

    // used for company or admin
    public UserDTO(int id, String email, String username) {
        this.id = String.valueOf(id);
        this.email = email;
        this.name = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public Set<String> getAppliedPositions() {
        return appliedPositions;
    }

    public void setAppliedPositions(Set<String> appliedPositions) {
        this.appliedPositions = appliedPositions;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
