package com.cloud.cloudproject.repository;

import com.cloud.cloudproject.entity.Game;
import com.cloud.cloudproject.entity.Person;
import com.cloud.cloudproject.entity.Rate;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.neo4j.repository.support.CypherdslConditionExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface RateRepository extends Neo4jRepository<Rate, Long>, CypherdslConditionExecutor<Rate> {

    @Query("MATCH (rate:Rate ) -[:RATING] -(:Game {title: $name}) RETURN rate")
    List<Rate> getRatingsOfGame(String name);

    @Query("MATCH (rateNode:Rate {rate: $rate}) - [:RATING] - (game:Game) RETURN game.title")
    String getRatedGame(int rate);

    @Query("MATCH (rate:Rate ) -[:RATING] -(:Game {title: $name}) RETURN avg(rate.rate)")
    double getAverageRatingOfGame(String name);

    @Query(" MATCH (game:Game) WHERE game.title = $title CREATE (r:Rate {rate: $rating})  MERGE (r)-[q:RATING]-(game)")
    String saveRatingOfGame(String title, int rating);
}