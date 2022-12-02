//package com.wju.job_portal.document;
//
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
//@Document(collection = "company")
//public class Company {
//    @Id
//    private String id;
//    private String name;
//    private String email;
//    private String password;
//    private Set<String> positionList = new HashSet<>();
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
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
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
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
//    public Set<String> getPositionList() {
//        return positionList;
//    }
//
//    public void setPositionList(Set<String> positionList) {
//        this.positionList = positionList;
//    }
//
//    @Override
//    public String toString() {
//        return "Company{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", positionList=" + positionList +
//                '}';
//    }
//}
