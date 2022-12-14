package com.cloud.cloudproject.repository;

import com.cloud.cloudproject.entity.Author;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface AuthorRepository extends Neo4jRepository<Author, Long>, QuerydslPredicateExecutor<Author> {

    @Query("MATCH (game:Game) WHERE game.title = $gametitle MERGE (a:Author {firstName: $firstn, lastName: $lastn})  MERGE (a)-[q:AUTHOR_GAME]-(game)")
    void saveAuthorOfExistingGame(String firstn,String lastn, String gametitle);

    @Query("MATCH (aut:Author ) -[:AUTHOR_GAME] -(:Game {title: $name}) RETURN aut")
    List<Author> getAllAuthorsOfGame(String name);

}
