//package com.wju.job_portal.document;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@Document(collection = "user")
//public class User {
//    @Id
//    private String id;
//    private boolean isAdmin;
//    private String email;
//    private String name;
//    private String password;
//    private Set<String> skills = new HashSet<>();
//    private Set<String> appliedPositions = new HashSet<>();
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public boolean isAdmin() {
//        return isAdmin;
//    }
//
//    public void setAdmin(boolean admin) {
//        isAdmin = admin;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Set<String> getSkills() {
//        return skills;
//    }
//
//    public void setSkills(Set<String> skills) {
//        this.skills = skills;
//    }
//
//    public Set<String> getAppliedPositions() {
//        return appliedPositions;
//    }
//
//    public void setAppliedPositions(Set<String> appliedPositions) {
//        this.appliedPositions = appliedPositions;
//    }
//
//    @Override
//    public String toString() {
//        return "Applicant{" +
//                "id='" + id + '\'' +
//                ", isAdmin=" + isAdmin +
//                ", email='" + email + '\'' +
//                ", name='" + name + '\'' +
//                ", password='" + password + '\'' +
//                ", skills=" + skills +
//                ", appliedPositions=" + appliedPositions +
//                '}';
//    }
//}
