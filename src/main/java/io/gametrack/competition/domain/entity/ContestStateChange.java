package io.gametrack.competition.domain.entity;

import io.gametrack.competition.domain.ContestState;

import java.util.Date;

/**
 * @author Kevin Sutton
 */
public class ContestStateChange {
    private Contest contest;
    private ContestState contestState;
    private Date when;

    public ContestStateChange(Contest contest, ContestState contestState) {
        this.contest = contest;
        this.contestState = contestState;
        this.when = new Date();
    }
}
