//package com.wju.job_portal.document;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import java.time.Instant;
//import java.util.HashSet;
//import java.util.Set;
//
//@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@Document(collection = "position")
//public class Position {
//    @Id
//    private String id;
//    private String title;
//    private String description;
//    private String location;
//    private String benefit;
//    private int salary;
//    private Instant postDate;
//    private Instant endDate;
//    private String createdByCompany;
//    private Set<String> requiredSkills = new HashSet<>();
//    private Set<String> candidatesList = new HashSet<>();
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getBenefit() {
//        return benefit;
//    }
//
//    public void setBenefit(String benefit) {
//        this.benefit = benefit;
//    }
//
//    public int getSalary() {
//        return salary;
//    }
//
//    public void setSalary(int salary) {
//        this.salary = salary;
//    }
//
//    public Instant getPostDate() {
//        return postDate;
//    }
//
//    public void setPostDate(Instant postDate) {
//        this.postDate = postDate;
//    }
//
//    public Instant getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(Instant endDate) {
//        this.endDate = endDate;
//    }
//
//    public String getCreatedByCompany() {
//        return createdByCompany;
//    }
//
//    public void setCreatedByCompany(String createdByCompany) {
//        this.createdByCompany = createdByCompany;
//    }
//
//    public Set<String> getRequiredSkills() {
//        return requiredSkills;
//    }
//
//    public void setRequiredSkills(Set<String> requiredSkills) {
//        this.requiredSkills = requiredSkills;
//    }
//
//    public Set<String> getCandidatesList() {
//        return candidatesList;
//    }
//
//    public void setCandidatesList(Set<String> candidatesList) {
//        this.candidatesList = candidatesList;
//    }
//
//    @Override
//    public String toString() {
//        return "Position{" +
//                "id='" + id + '\'' +
//                ", title='" + title + '\'' +
//                ", description='" + description + '\'' +
//                ", location='" + location + '\'' +
//                ", benefit='" + benefit + '\'' +
//                ", salary=" + salary +
//                ", postDate=" + postDate +
//                ", endDate=" + endDate +
//                ", createdByCompany='" + createdByCompany + '\'' +
//                ", skills=" + requiredSkills +
//                ", candidateList=" + candidatesList +
//                '}';
//    }
//}
