package com.cloud.cloudproject.repository;

import com.cloud.cloudproject.entity.Genre;
import com.cloud.cloudproject.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface GenreRepository extends Neo4jRepository<Genre, Long>, QuerydslPredicateExecutor<Genre> {
}
