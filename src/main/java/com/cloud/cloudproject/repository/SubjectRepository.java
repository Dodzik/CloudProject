package com.cloud.cloudproject.repository;

import com.cloud.cloudproject.entity.Subject;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface SubjectRepository extends Neo4jRepository<Subject, Long>, QuerydslPredicateExecutor<Subject> {

    @Query("MATCH (sub:Subject ) -[:HAS_SUBJECT] -(:Game {title: $name}) RETURN sub")
    List<Subject> getAllSubjectsOfGame(String name);

}
