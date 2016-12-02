package io.gametrack.competition.service;

import io.gametrack.competition.domain.ContestState;
import io.gametrack.competition.domain.entity.ContestStateChange;
import io.gametrack.competition.domain.entity.Contest;

/**
 * @author Kevin Sutton
 */
public class ContestStateService {

    public void setState(Contest contest, ContestState contestState) {
        if (contest.getState().equals(contestState)) {
            return;
        }
        ContestStateChange change = new ContestStateChange(contest, contestState);
        contest.setState(contestState);
//        contest.addStateChange(change);
        // TODO: save contest
    }

}
