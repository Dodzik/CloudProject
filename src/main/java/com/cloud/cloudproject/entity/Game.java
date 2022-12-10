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
public class Game {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
//    private int rate;

    @Relationship(type = "HAS_GENRE")
    public Set<Genre> hasGenre;

    @Relationship(type = "HAS_SUBJECT")
    public Set<Subject> hasSubject;


    public void genreIs(Genre genre) {
        if (hasGenre == null) {
            hasGenre = new HashSet<>();
        }
        hasGenre.add(genre);
    }

    public void subjectIs(Subject subject) {
        if (hasSubject == null) {
            hasSubject = new HashSet<>();
        }
        hasSubject.add(subject);
    }
}
