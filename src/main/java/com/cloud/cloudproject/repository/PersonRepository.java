package com.cloud.cloudproject.repository;

import java.util.List;

import com.cloud.cloudproject.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import reactor.core.publisher.Flux;

public interface PersonRepository extends Neo4jRepository<Person, Long>, QuerydslPredicateExecutor<Person> {
//public interface PersonRepository extends ReactiveNeo4jRepository<Person, Long> {

//    @Query("MATCH(person:Person)-[r:TEAMMATE]-(p:Person) WHERE person.name =~ $name RETURN person")
//    @Query("MATCH (:Person {name: 'Greg'})-[:TEAMMATE]->(p:Person) RETURN p")
    @Query("MATCH (person:`Person`) RETURN person.name")
    List<Person> getperson(String name);

//    @Query("MATCH(person:Person) WHERE person.name =~ $name RETURN person")
//    @Query("MATCH(person:Person) WHERE person.name =~ $name RETURN person")
    @Query("MATCH (person:`Person`) WHERE person.name = $name RETURN person")
    Person getperson2(String name);
//    Flux<Person> findByTitleContains(String name);
    Person findByName(String name);
    List<Person> findByTeammatesName(String name);
}
