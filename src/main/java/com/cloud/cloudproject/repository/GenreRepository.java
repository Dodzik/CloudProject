package com.cloud.cloudproject.repository;

import com.cloud.cloudproject.entity.Genre;
import com.cloud.cloudproject.entity.Person;
import com.cloud.cloudproject.entity.Subject;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface GenreRepository extends Neo4jRepository<Genre, Long>, QuerydslPredicateExecutor<Genre> {

    @Query("MATCH (gen:Genre ) -[:HAS_GENRE] -(:Game {title: $name}) RETURN gen")
    List<Genre> getAllGenresOfGame(String name);
}
