package com.cloud.cloudproject;

import org.neo4j.cypherdsl.core.renderer.Renderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootApplication
@EnableNeo4jRepositories
public class CloudProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudProjectApplication.class, args);
    }


}

