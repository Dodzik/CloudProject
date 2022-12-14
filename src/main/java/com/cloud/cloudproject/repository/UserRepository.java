package com.cloud.cloudproject.repository;

import com.cloud.cloudproject.entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface UserRepository extends Neo4jRepository<User, Long>, QuerydslPredicateExecutor<User> {

    @Query("Create (u:User {login :$login, pass :$pass})")
    void saveUser(String login, String pass);

    @Query("MATCH (u:User) RETURN u")
    List<User> getAllUsers();
}
