package com.wju.job_portal.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_skills")
public class UserSkills implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_skills_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userSkillsId;

    @Column(name = "skills")
    private String skills;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id",nullable=false)
    private Users users;

    public void setUserSkillsId(Integer userSkillsId) {
        this.userSkillsId = userSkillsId;
    }

    public Integer getUserSkillsId() {
        return userSkillsId;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getSkills() {
        return skills;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserSkills{" +
                "userSkillsId=" + userSkillsId + '\'' +
                "skills=" + skills + '\'' +
                '}';
    }
}
