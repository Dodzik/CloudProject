package com.cloud.cloudproject.repository;

import com.cloud.cloudproject.entity.Author;
import com.cloud.cloudproject.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface AuthorRepository extends Neo4jRepository<Author, Long>, QuerydslPredicateExecutor<Author> {

}
