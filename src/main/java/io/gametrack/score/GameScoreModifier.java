package io.gametrack.score;

import io.gametrack.core.EventType;
import io.gametrack.GametrackException;
import io.gametrack.GametrackExceptionType;
import io.gametrack.competition.domain.entity.Game;
import io.gametrack.score.validation.ScoreValidator;
import io.gametrack.score.validation.ScoreValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.bus.EventBus;

/**
 * @author Kevin Sutton
 */
@Service
public class GameScoreModifier implements ScoreModifier<Game> {

    EventBus eventBus;

    @Autowired
    public GameScoreModifier(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void modifyScore(Game game, ScorePair scorePair) {

        ScoreValidator scoreValidator = ScoreValidatorFactory.getScoreValidator(game);

        if (!scoreValidator.isValidScore(scorePair.getScoreOne(), scorePair.getScoreTwo())) {
            throw new GametrackException(GametrackExceptionType.INVALID_SCORE,
                    "Score: " + scorePair.getScoreOne() + "-" + scorePair.getScoreTwo());
        }

        game.setScores(scorePair);

        //TODO: save game

        eventBus.notify(EventType.GAME_SCORE_CHANGE, Event.wrap(game));
    }

}
