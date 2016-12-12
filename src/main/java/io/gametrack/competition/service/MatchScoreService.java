package io.gametrack.competition.service;

import io.gametrack.competition.domain.entity.Game;
import io.gametrack.competition.domain.entity.Match;
import io.gametrack.competition.domain.repository.MatchRepository;
import io.gametrack.core.EventType;
import io.gametrack.player.Side;
import io.gametrack.score.MatchScoreModifier;
import io.gametrack.score.ScorePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class MatchScoreService implements Consumer<Event<Game>>   {

    private final EventBus bus;
    private final MatchRepository matchRepository;
    private final MatchScoreModifier matchScoreModifier;

    private static final Logger logger = LoggerFactory.getLogger(MatchScoreService.class);

    @Autowired
    public MatchScoreService(EventBus bus, MatchRepository matchRepository, MatchScoreModifier matchScoreModifier) {
        this.bus = bus;
        this.matchRepository = matchRepository;
        this.matchScoreModifier = matchScoreModifier;
    }

    @PostConstruct
    public void registerListeners() {
        bus.on($(EventType.GAME_STATE_CHANGE), this);
    }

    @Override
    public void accept(Event<Game> ev) {
        Game game = ev.getData();
        updateMatchScore(game);
    }

    private void updateMatchScore(Game game) {
        ScorePair scorePair = calculateMatchScore(game.getMatch());
        matchScoreModifier.modifyScore(game.getMatch(), scorePair);
    }

    public ScorePair calculateMatchScore(Match match) {
        logger.info("Recalculating match score");
        int scoreOne = 0;
        int scoreTwo = 0;
        for (Game game : match.getGames()) {
            if (game.getWinner().isPresent()) {
                Side winner = game.getWinner().get();
                if (winner.equals(match.getScores().get(0).getSide())) {
                    scoreOne++;
                } else {
                    scoreTwo++;
                }
            }
        }
        return new ScorePair(scoreOne, scoreTwo);
    }

}
