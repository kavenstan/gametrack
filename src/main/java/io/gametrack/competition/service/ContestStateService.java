package io.gametrack.competition.service;

import io.gametrack.competition.domain.ContestState;
import io.gametrack.competition.domain.entity.Contest;
import io.gametrack.competition.domain.entity.ContestStateChange;
import io.gametrack.competition.domain.entity.Game;
import io.gametrack.core.EventType;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.bus.EventBus;

/**
 * @author Kevin Sutton
 */
@Service
public class ContestStateService {

    private final EventBus eventBus;

    public ContestStateService(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void setState(Contest contest, ContestState contestState) {
        if (contest.getState().equals(contestState)) {
            return;
        }
        ContestStateChange change = new ContestStateChange(contest, contestState);
        contest.setState(contestState);

        if (contest instanceof Game) {
            eventBus.notify(EventType.GAME_STATE_CHANGE, Event.wrap(contest));
        }

//        contest.addStateChange(change);
        // TODO: save contest
    }

}
