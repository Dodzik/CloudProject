package com.cloud.cloudproject.Controller;

import com.cloud.cloudproject.Controller.request.GameName;
import com.cloud.cloudproject.Controller.request.RatingGame;
import com.cloud.cloudproject.entity.Game;
import com.cloud.cloudproject.entity.Rate;
import com.cloud.cloudproject.repository.GameRepository;
import com.cloud.cloudproject.repository.RateRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class RateController {

    private RateRepository rateRepository;
    private GameRepository gameRepository;

    @PostMapping("/api/ratesforgame")
    public List<Rate> getRatesForGame(@RequestBody GameName gameName) {
        log.info(gameName.title);
        return rateRepository.getRatingsOfGame(gameName.title);
    }

    @PostMapping("/api/avgratesforgame")
    public double getAverageRatesForGame(@RequestBody GameName gameName) {
        log.info(gameName.title);
        if (rateRepository.getRatingsOfGame(gameName.title).size() == 0 ||
                !gameRepository.findAll().stream().map(Game::getTitle).toList().contains(gameName.title)) {
            return 0.0;
        }
        return rateRepository.getAverageRatingOfGame(gameName.title);
    }

    @PostMapping("/api/ratethisgame")
    public void saveRateOfGame(@RequestBody RatingGame ratingGame) {
        log.info(ratingGame.title);
        log.info(String.valueOf(ratingGame.points));
        rateRepository.saveRatingOfGame(ratingGame.login, ratingGame.title, ratingGame.points);
    }
}
