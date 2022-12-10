package com.cloud.cloudproject.Controller;

import com.cloud.cloudproject.Controller.request.GameName;
import com.cloud.cloudproject.entity.Game;
import com.cloud.cloudproject.repository.GameRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class GameController {

    private GameRepository gameRepository;

    @PostMapping("/api/games")
    public List<Game> getgames() {
        log.info(gameRepository.findAll().toString());
        return gameRepository.findAll();
    }

    @PostMapping("/api/savegame")
    public void saveGame(@RequestBody GameName gameName){
        if (gameName == null){
            return;
        }
        log.info(gameName.title);
        gameRepository.save(
        Game.builder()
                .title(gameName.title)
                .build()
        );
    }

    @PostMapping("/api/topfivegames")
    public List<Game> getFiveGame(){
        return gameRepository.get5BestRatedGames();
    }

    @PostMapping("/api/filteringTitles")
    public List<Game> getFiltererdGames(@RequestBody GameName gameName){
        log.info(gameName.title);
        return gameRepository.getTitlesContains(gameName.title);
    }


}
