package io.gametrack.competition.web;

import io.gametrack.competition.domain.ScoreSystem;
import io.gametrack.competition.domain.entity.Game;
import io.gametrack.competition.domain.entity.Match;
import io.gametrack.competition.domain.repository.GameRepository;
import io.gametrack.player.Gender;
import io.gametrack.player.Side;
import io.gametrack.player.Sides;
import io.gametrack.score.GameScoreModifier;
import io.gametrack.score.ScorePair;
import io.gametrack.score.validation.ScoreValidator;
import io.gametrack.score.validation.ScoreValidatorFactory;
import io.gametrack.simulation.PlayerCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Kevin Sutton
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private final GameScoreModifier gameScoreModifier;
    private final GameRepository gameRepository;

    @Autowired
    public TestController(GameScoreModifier gameScoreModifier, GameRepository gameRepository) {
        this.gameScoreModifier = gameScoreModifier;
        this.gameRepository = gameRepository;
    }

    @RequestMapping("/")
    public String index() {
        PlayerCreator playerCreator = new PlayerCreator();

        for (int i = 0; i < 10; i++) {

            Side sideOne = new Side();
            sideOne.addPlayer(playerCreator.createPlayer(Gender.MALE));
            Side sideTwo = new Side();
            sideTwo.addPlayer(playerCreator.createPlayer(Gender.MALE));
            Sides sides = new Sides(sideOne, sideTwo);

            Match match = new Match.Builder()
                    .withSides(sides)
                    .withHomeSide(sideOne)
                    .withScoreSystem(ScoreSystem.MATCH_BEST_OF_THREE_GAMES)
                    .build();

            ScoreValidator matchValidator = ScoreValidatorFactory.getScoreValidator(match);

            while(!matchValidator.isValidResult(match.getScorePair().getScoreOne(), match.getScorePair().getScoreTwo())) {
                Game game = new Game.Builder(match)
                        .withScoreSystem(ScoreSystem.GAME_WITH_SETTING)
                        .build();

                ScoreValidator gameValidator = ScoreValidatorFactory.getScoreValidator(game);
                while(!gameValidator.isValidResult(game.getScorePair().getScoreOne(), game.getScorePair().getScoreTwo())) {
                    ScorePair gameScorePair = new ScorePair(game.getScorePair().getScoreOne() + 1, game.getScorePair().getScoreTwo());
                    gameScoreModifier.modifyScore(game, gameScorePair);
                }
            }

        }

        List<Game> games = gameRepository.findAll();

        logger.info("Game size: " + games.size());

        return "Greetings from Spring Boot!";
    }

}
