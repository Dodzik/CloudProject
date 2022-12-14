package com.cloud.cloudproject.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node
@Getter
@Setter
@ToString
@Builder
public class User {

    @Relationship(type = "MY_RATE")
    public Set<Rate> myRate;
    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String pass;

    public void setMyRating(Rate rate) {
        if (myRate == null) {
            myRate = new HashSet<>();
        }
        myRate.add(rate);
    }

}
