package com.cloud.cloudproject.Controller;

import com.cloud.cloudproject.Controller.request.AuthorGame;
import com.cloud.cloudproject.Controller.request.GameName;
import com.cloud.cloudproject.entity.Author;
import com.cloud.cloudproject.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class AuthorController {

    private AuthorRepository authorRepository;

    @PostMapping("/api/authorOfGame")
    public void addAuthorOfGame(@RequestBody AuthorGame authorGame) {
        log.info(authorGame.toString());
        authorRepository.saveAuthorOfExistingGame(authorGame.firstn, authorGame.lastn, authorGame.gametitle);
    }

    @PostMapping("/api/getAllAuthorsOfGame")
    public List<Author> addAuthorOfGame(@RequestBody GameName gameName) {
        return authorRepository.getAllAuthorsOfGame(gameName.title);
    }
}
