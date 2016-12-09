package io.gametrack.competition.service;

import io.gametrack.competition.domain.ContestState;
import io.gametrack.competition.domain.entity.Game;
import io.gametrack.core.EventType;
import io.gametrack.player.Side;
import io.gametrack.score.ScorePair;
import io.gametrack.score.validation.ScoreValidator;
import io.gametrack.score.validation.ScoreValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.bus.EventBus;
import reactor.fn.Consumer;

import javax.annotation.PostConstruct;

import static reactor.bus.selector.Selectors.$;

/**
 * @author Kevin Sutton
 */
@Service
public class GameEvaluator implements Consumer<Event<Game>> {

    private final EventBus bus;
    private final ContestStateService stateService;

    @Autowired
    public GameEvaluator(EventBus bus, ContestStateService stateService) {
        this.bus = bus;
        this.stateService = stateService;
    }

    @PostConstruct
    public void registerListeners() {
        bus.on($(EventType.GAME_SCORE_CHANGE), this);
    }

    @Override
    public void accept(Event<Game> ev) {
        Game game = ev.getData();
        evaluate(game);
    }

    private void evaluate(Game game) {
        ScoreValidator validator = ScoreValidatorFactory.getScoreValidator(game);

        ScorePair scorePair = game.getScorePair();
        boolean gameComplete = validator.isValidResult(scorePair.getScoreOne(), scorePair.getScoreTwo());

        if (gameComplete) {
            stateService.setState(game, ContestState.WON);
            game.setWinner(winner(game));
        }
        else {
            if (!game.getState().equals(ContestState.IN_PROGRESS)) {
                stateService.setState(game, ContestState.IN_PROGRESS);
            }
        }

    }

    private Side winner(Game game) {
        ScorePair scorePair = game.getScorePair();
        return game.getScores().get(scorePair.getScoreOne() > scorePair.getScoreTwo() ? 0 : 1).getSide();
    }

}
