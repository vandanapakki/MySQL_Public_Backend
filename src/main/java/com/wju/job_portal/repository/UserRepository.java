//package com.wju.job_portal.repository;
//
//import com.wju.job_portal.document.User;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface UserRepository extends MongoRepository<User, String> {
//    @Query
//    Optional<User> findById(String id);
//
//    @Query
//    Optional<User> findByEmail(String email);
//
//
//}
