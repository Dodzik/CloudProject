package com.cloud.cloudproject.repository;

import com.cloud.cloudproject.entity.Person;
import com.cloud.cloudproject.entity.Subject;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface SubjectRepository extends Neo4jRepository<Subject, Long>, QuerydslPredicateExecutor<Subject> {
}
