package com.cloud.cloudproject.repository;

import com.cloud.cloudproject.entity.Game;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface GameRepository extends Neo4jRepository<Game, Long>, QuerydslPredicateExecutor<Game> {

    @Query("MATCH (rateNode:Rate {rate: $rate}) - [:RATING] - (game:Game) RETURN game")
    Game getRatedGame(int rate);

    @Query("MATCH (searched: Game) WHERE searched.title CONTAINS $regex RETURN searched")
    List<Game> getTitlesContains(String regex);

    @Query("MATCH (rate:Rate ) -[:RATING] -(g:Game) WITH g,avg(rate.rate) as p ORDER BY p DESC  RETURN g LIMIT 5")
    List<Game> get5BestRatedGames();

    @Query("MATCH (game:Game) WHERE game.title = $title MERGE (g:Genre {name: $genreName})  MERGE (game)-[q:HAS_GENRE]-(g)")
    void addGenreToGame(String title, String genreName);

    @Query("MATCH (game:Game) WHERE game.title = $title MERGE (s:Subject {name: $subjectName})  MERGE (game)-[q:HAS_SUBJECT]-(s)")
    void addSubjectToGame(String title, String subjectName);
}