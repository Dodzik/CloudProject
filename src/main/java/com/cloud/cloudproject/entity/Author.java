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
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    @Relationship(type = "AUTHOR_GAME")
    public Set<Game> authorGame;

    public void authorOf(Game game) {
        if (authorGame == null) {
            authorGame = new HashSet<>();
        }
        authorGame.add(game);
    }

}
