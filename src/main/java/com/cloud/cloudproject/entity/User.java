package com.cloud.cloudproject.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

@Node
@Getter
@Setter
@ToString
@Builder
public class User {

    @Id @GeneratedValue private Long id;

    private String login;
    private String pass;

    @Relationship(type = "MY_RATE")
    public Set<Rate> myRate;

    public void setMyRating(Rate rate) {
        if (myRate == null) {
            myRate = new HashSet<>();
        }
        myRate.add(rate);
    }

}
