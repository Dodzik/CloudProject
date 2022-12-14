package com.cloud.cloudproject.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
@Getter
@Setter
@ToString
@Builder
public class Rate {
    @Id
    @GeneratedValue
    private Long id;

    private int rate;
    @Relationship(type = "RATING")
    public Game game;

    public void ratingOf(Game game) {
        this.game = game;
    }

}
