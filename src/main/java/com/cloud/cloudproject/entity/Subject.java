package com.cloud.cloudproject.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Getter
@Setter
@ToString
@Builder
public class Subject {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
