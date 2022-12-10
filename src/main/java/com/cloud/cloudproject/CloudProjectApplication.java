package com.cloud.cloudproject;

import com.cloud.cloudproject.entity.Person;
import com.cloud.cloudproject.repository.PersonRepository;
import org.neo4j.cypherdsl.core.Cypher;
import org.neo4j.cypherdsl.core.Node;
import org.neo4j.cypherdsl.core.Property;
import org.neo4j.cypherdsl.core.renderer.Renderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootApplication
@EnableNeo4jRepositories
public class CloudProjectApplication {
    private static final Renderer cypherRenderer = Renderer.getDefaultRenderer();
    private final static Logger log = LoggerFactory.getLogger(CloudProjectApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CloudProjectApplication.class, args);
//        System.exit(0);
    }
//    @Bean
//    CommandLineRunner demo(PersonRepository personRepository) {
//        return args -> {
//
//
//            personRepository.deleteAll();
//
//            Person greg = new Person("Greg");
//            Person roy = new Person("Roy");
//            Person craig = new Person("Craig");
//
//            List<Person> team = Arrays.asList(greg, roy, craig);
//
//            log.info("Before linking up with Neo4j...");
//
//            team.stream().forEach(person -> log.info("\t" + person.toString()));
//
//            personRepository.save(greg);
//            personRepository.save(roy);
//            personRepository.save(craig);
//
//            greg = personRepository.findByName(greg.getName());
//            greg.worksWith(roy);
//            greg.worksWith(craig);
//            personRepository.save(greg);
//
//            roy = personRepository.findByName(roy.getName());
//            roy.worksWith(craig);
//            // We already know that roy works with greg
//            personRepository.save(roy);
//
//            // We already know craig works with roy and greg
//            // my
////            team = personRepository.findAll();
//
//            log.info("Lookup each person by name...");
//            team.stream().forEach(person -> log.info(
//                    "\t" + personRepository.findByName(person.getName()).toString()));
//
//            List<Person> teammates = personRepository.findByTeammatesName(greg.getName());
//            log.info("The following have Greg as a teammate...");
//            teammates.stream().forEach(person -> log.info("\t" + person.getName()));

//            var people = Cypher.node("Person").named("person");
//            var statement  = Cypher
//                    .match(people)
//                    .where(people.property("name").isEqualTo(Cypher.parameter("name")))
//                    .returning(people)
////                    .limit(3)
//                    .build();
//            System.out.println(cypherRenderer.render(statement));
//            personRepository.save(greg);
//            personRepository.save(roy);
//            personRepository.save(craig);
//            var statement = Cypher
//                    .match(gregst.relationshipTo()
//                    )
//            System.out.println(statement.);
//            assertThat(cypherRenderer.render(statement))
//                    .isEqualTo("MATCH (people:`Person`) RETURN people.name LIMIT 2");
//            Node person = Cypher.node("Person").named("person");
//            System.out.println(Cypher.node("Person").named("person"));
//            System.out.println(personRepository.findAll());
//            System.out.println(personRepository.findByName("Craig"));
//            System.out.println(personRepository.getperson2("Greg"));
//            System.out.println(personRepository.getperson("Greg"));
//            System.out.println(personRepository.findByName("Greg"));
//            System.out.println(personRepository.findByTitleContains("Craig"));
//            Property firstName = person.property("firstName");
//            Property lastName = person.property("lastName");

//            assertThat(
//                    personRepository.findAll(
//
//                    ))
//                    .extracting(Person::getName)
//                    .containsExactly("Helge", "Bela");



//        };
//    }

}

