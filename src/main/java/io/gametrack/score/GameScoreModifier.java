package io.gametrack.score;

import io.gametrack.competition.domain.repository.GameRepository;
import io.gametrack.core.EventType;
import io.gametrack.GametrackException;
import io.gametrack.GametrackExceptionType;
import io.gametrack.competition.domain.entity.Game;
import io.gametrack.score.validation.ScoreValidator;
import io.gametrack.score.validation.ScoreValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.bus.Event;
import reactor.bus.EventBus;

/**
 * @author Kevin Sutton
 */
@Service
public class GameScoreModifier implements ScoreModifier<Game> {

    private final EventBus eventBus;
    private final GameRepository gameRepository;


    @Autowired
    public GameScoreModifier(EventBus eventBus, GameRepository gameRepository) {
        this.eventBus = eventBus;
        this.gameRepository = gameRepository;
    }

    @Override
    @Transactional
    public void modifyScore(Game game, ScorePair scorePair) {

        ScoreValidator scoreValidator = ScoreValidatorFactory.getScoreValidator(game);

        if (!scoreValidator.isValidScore(scorePair.getScoreOne(), scorePair.getScoreTwo())) {
            throw new GametrackException(GametrackExceptionType.INVALID_SCORE,
                    "Score: " + scorePair.getScoreOne() + "-" + scorePair.getScoreTwo());
        }

        game.setScores(scorePair);

        gameRepository.save(game);

        eventBus.notify(EventType.GAME_SCORE_CHANGE, Event.wrap(game));
    }

}
