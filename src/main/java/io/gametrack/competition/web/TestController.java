package io.gametrack.competition.web;

import io.gametrack.competition.domain.GameType;
import io.gametrack.competition.domain.ScoreSystemType;
import io.gametrack.competition.domain.entity.Game;
import io.gametrack.competition.domain.entity.Match;
import io.gametrack.competition.domain.repository.GameRepository;
import io.gametrack.competition.domain.repository.GameScoreRepository;
import io.gametrack.competition.domain.repository.MatchRepository;
import io.gametrack.competition.domain.repository.MatchScoreRepository;
import io.gametrack.player.Gender;
import io.gametrack.player.Side;
import io.gametrack.player.Sides;
import io.gametrack.player.domain.repository.SideRepository;
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
import java.util.stream.Collectors;

/**
 * @author Kevin Sutton
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private final GameScoreModifier gameScoreModifier;
    private final GameRepository gameRepository;
    private final MatchRepository matchRepository;
    private final SideRepository sideRepository;
    private final GameScoreRepository gameScoreRepository;
    private final MatchScoreRepository matchScoreRepository;

    @Autowired
    public TestController(GameScoreModifier gameScoreModifier,
                          GameRepository gameRepository,
                          MatchRepository matchRepository,
                          SideRepository sideRepository,
                          GameScoreRepository gameScoreRepository,
                          MatchScoreRepository matchScoreRepository) {
        this.gameScoreModifier = gameScoreModifier;
        this.gameRepository = gameRepository;
        this.matchRepository = matchRepository;
        this.sideRepository = sideRepository;
        this.gameScoreRepository = gameScoreRepository;
        this.matchScoreRepository = matchScoreRepository;
    }

    @RequestMapping("/view")
    public String view() {
        return "Hi";
    }

    @RequestMapping("/list")
    public List<MatchResultDTO> listMatches() {
//        return matchRepository.findAll().stream().map(MatchDTO::new).collect(Collectors.toList());
        return matchRepository.findAll().stream().map(MatchResultDTO::new).collect(Collectors.toList());
    }

    @RequestMapping("/create")
    public String create() throws InterruptedException {
        PlayerCreator playerCreator = new PlayerCreator();

        for (int i = 0; i < 10; i++) {

            Side sideOne = new Side();
            sideOne.addPlayer(playerCreator.createPlayer(Gender.MALE));
            Side sideTwo = new Side();
            sideTwo.addPlayer(playerCreator.createPlayer(Gender.MALE));
            Sides sides = new Sides(sideOne, sideTwo);
            sideRepository.save(sideOne);
            sideRepository.save(sideTwo);

            Match match = new Match.Builder(GameType.MENS_SINGLES, ScoreSystemType.MATCH_BEST_OF_THREE_GAMES, sides)
                    .withHomeSide(sideOne)
                    .build();

            matchRepository.save(match);
            match.getScores().stream().forEach(matchScoreRepository::save);

            ScoreValidator matchValidator = ScoreValidatorFactory.getScoreValidator(match);

            while(!matchValidator.isValidResult(match.getScorePair().getScoreOne(), match.getScorePair().getScoreTwo())) {
                Game game = new Game.Builder(match, ScoreSystemType.GAME_WITH_SETTING)
                        .build();

                gameRepository.save(game);
                game.getScores().stream().forEach(gameScoreRepository::save);

                ScoreValidator gameValidator = ScoreValidatorFactory.getScoreValidator(game);
                while(!gameValidator.isValidResult(game.getScorePair().getScoreOne(), game.getScorePair().getScoreTwo())) {
                    ScorePair gameScorePair = new ScorePair(game.getScorePair().getScoreOne() + 1, game.getScorePair().getScoreTwo());
                    gameScoreModifier.modifyScore(game, gameScorePair);
                }
                Thread.sleep(1000);
            }

        }

        List<Game> games = gameRepository.findAll();

        logger.info("Game size: " + games.size());

        return "Created " + games.size() + " games.";
    }

}
