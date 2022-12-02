package com.wju.job_portal.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_type", schema = "job_portal")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_type_id", unique = true, nullable = false)
    private int userTypeId;
    @Column(name = "user_type")
    private String userType;

//    @OneToMany(mappedBy = "UserType", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<Users> users;

    //private Set<Users> users = new HashSet<>();

    public UserType() {

    }

    public UserType(int userTypeId, String userType) {
        this.userTypeId = userTypeId;
        this.userType = userType;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

//    public Set<Users> getUsers() {
//        return this.users;
//    }
//
//    public void setUsers(Set<Users> users) {
//        this.users = users;
//    }


}
