package com.cloud.cloudproject;

import com.cloud.cloudproject.entity.*;
import com.cloud.cloudproject.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
class ExampleCommandLineRunner implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private GameRepository gameRepository;
    private GenreRepository genreRepository;
    private SubjectRepository subjectRepository;
    private RateRepository rateRepository;
    private UserRepository userRepository;

    public void clear() {
        authorRepository.deleteAll();
        gameRepository.deleteAll();
        genreRepository.deleteAll();
        subjectRepository.deleteAll();
        rateRepository.deleteAll();
        userRepository.deleteAll();
    }


    @Override
    public void run(String... args) throws Exception {
        clear();
        Genre genre1 = Genre.builder()
                .name("FPS")
                .build();
        Genre genre2 = Genre.builder()
                .name("Multiplayer")
                .build();
        Genre genre3 = Genre.builder()
                .name("Farming")
                .build();

        Subject subject1 = Subject.builder()
                .name("War")
                .build();
        Subject subject2 = Subject.builder()
                .name("Zombie")
                .build();
        Subject subject3 = Subject.builder()
                .name("Medieval")
                .build();

        Author author1 = Author.builder()
                .firstName("Abacki")
                .lastName("Babacki")
                .build();
        Author author2 = Author.builder()
                .firstName("Miłosz")
                .lastName("Tokarz")
                .build();
        Author author3 = Author.builder()
                .firstName("Wojtek")
                .lastName("Budowlaniec")
                .build();


        Game game1 = Game.builder()
                .title("Endless War")
                .build();

        Game game2 = Game.builder()
                .title("Dying Simulator")
                .build();
        Game game3 = Game.builder()
                .title("Watcher")
                .build();
        Game game4 = Game.builder()
                .title("Mortar 2")
                .build();
        Game game5 = Game.builder()
                .title("Counter-Spike")
                .build();

        Rate rate1 = Rate.builder()
                .rate(3)
                .build();
        Rate rate2 = Rate.builder()
                .rate(9)
                .build();
        Rate rate3 = Rate.builder()
                .rate(4)
                .build();
        Rate rate4 = Rate.builder()
                .rate(2)
                .build();
        Rate rate5 = Rate.builder()
                .rate(3)
                .build();
        Rate rate6 = Rate.builder()
                .rate(0)
                .build();
        Rate rate7 = Rate.builder()
                .rate(10)
                .build();
        Rate rate8 = Rate.builder()
                .rate(5)
                .build();
        Rate rate9 = Rate.builder()
                .rate(7)
                .build();
        Rate rate10 = Rate.builder()
                .rate(1)
                .build();

        User user1 = User.builder()
                .login("test1")
                .pass("test1")
                .build();
        User user2 = User.builder()
                .login("test2")
                .pass("test2")
                .build();
        User user3 = User.builder()
                .login("test3")
                .pass("test3")
                .build();
        User user4 = User.builder()
                .login("test4")
                .pass("test4")
                .build();
        User user5 = User.builder()
                .login("test5")
                .pass("test6")
                .build();
        User user6 = User.builder()
                .login("test6")
                .pass("test6")
                .build();
        User user7 = User.builder()
                .login("test7")
                .pass("test7")
                .build();

        user1.setMyRating(rate1);
        user2.setMyRating(rate2);
        user3.setMyRating(rate3);
        user4.setMyRating(rate4);
        user5.setMyRating(rate5);
        user6.setMyRating(rate6);
        user7.setMyRating(rate7);
        user1.setMyRating(rate8);
        user2.setMyRating(rate9);
        user3.setMyRating(rate10);


        rate1.ratingOf(game1);
        rate2.ratingOf(game2);
        rate3.ratingOf(game3);
        rate4.ratingOf(game4);
        rate5.ratingOf(game5);
        rate6.ratingOf(game1);
        rate7.ratingOf(game2);
        rate8.ratingOf(game3);
        rate9.ratingOf(game4);
        rate10.ratingOf(game5);

        game1.genreIs(genre1);
        game2.genreIs(genre2);
        game3.genreIs(genre3);
        game4.genreIs(genre2);
        game5.genreIs(genre1);

        game1.subjectIs(subject1);
        game2.subjectIs(subject2);
        game3.subjectIs(subject3);
        game4.subjectIs(subject2);
        game5.subjectIs(subject1);

        author1.authorOf(game2);
        author1.authorOf(game4);
        author1.authorOf(game3);

        author2.authorOf(game3);
        author2.authorOf(game5);
        author2.authorOf(game1);

        author3.authorOf(game1);
        author3.authorOf(game2);

        subjectRepository.saveAll(List.of(subject1, subject2, subject3));
        genreRepository.saveAll(List.of(genre1, genre2, genre3));
        gameRepository.saveAll(List.of(game1, game2, game3, game4, game5));
        authorRepository.saveAll(List.of(author1, author2, author3));
        rateRepository.saveAll(List.of(rate1, rate2, rate3, rate4, rate5, rate6, rate7, rate8, rate9, rate10));
        userRepository.saveAll(List.of(user1, user2, user3, user4, user5, user6, user7));

    }
}