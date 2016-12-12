package io.gametrack.score;

import io.gametrack.GametrackException;
import io.gametrack.GametrackExceptionType;
import io.gametrack.competition.domain.entity.Match;
import io.gametrack.competition.domain.repository.MatchRepository;
import io.gametrack.core.EventType;
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
public class MatchScoreModifier implements ScoreModifier<Match> {

    private final EventBus eventBus;
    private final MatchRepository matchRepository;


    @Autowired
    public MatchScoreModifier(EventBus eventBus, MatchRepository matchRepository) {
        this.eventBus = eventBus;
        this.matchRepository = matchRepository;
    }

    @Override
    @Transactional
    public void modifyScore(Match match, ScorePair scorePair) {

        ScoreValidator scoreValidator = ScoreValidatorFactory.getScoreValidator(match);

        if (!scoreValidator.isValidScore(scorePair.getScoreOne(), scorePair.getScoreTwo())) {
            throw new GametrackException(GametrackExceptionType.INVALID_SCORE,
                    "Score: " + scorePair.getScoreOne() + "-" + scorePair.getScoreTwo());
        }

        match.setScores(scorePair);

        matchRepository.save(match);

        eventBus.notify(EventType.MATCH_SCORE_CHANGE, Event.wrap(match));
    }
}
