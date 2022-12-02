//package com.wju.job_portal.repository;
//
//import com.wju.job_portal.document.Position;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//
//import java.time.Instant;
//import java.util.List;
//
//public interface PositionRepository extends MongoRepository<Position, String> {
//
//    @Query(value = "{'salary': {'$gte': ?0}}")
//    List<Position> findBySalary(int salary);
//
//    @Query(value = "{'postDate': {'$gte': ?0}}")
//    List<Position> findByPostDate(Instant postDate);
//
//    @Query(value = "{'description': {'$regex': ?0, '$options': 'i'}}")
//    List<Position> findByDescription(String description);
//
//    @Query(value = "{'createdByCompany': ?0}")
//    List<Position> findByCompany(String companyName);
//}
