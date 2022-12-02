package com.wju.job_portal.repository;

import com.wju.job_portal.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {
    UserType getByUserTypeId(int id);
}
