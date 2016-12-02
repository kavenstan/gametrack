package io.gametrack.competition.domain.entity;

import io.gametrack.competition.domain.ContestRules;
import io.gametrack.core.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Kevin Sutton
 */
@Entity
@Table(name = "match_contest_rules")
public class MatchContestRules extends BaseEntity implements ContestRules {

    private int bestOf;
    private boolean playAll;
    private boolean drawAllowed;

    public MatchContestRules(int bestOf, boolean playAll, boolean drawAllowed) {
        this.bestOf = bestOf;
        this.playAll = playAll;
        this.drawAllowed = drawAllowed;
    }

    @Override
    public int bestOf() {
        return bestOf;
    }

    @Override
    public boolean playAll() {
        return playAll;
    }

    @Override
    public boolean drawAllowed() {
        return drawAllowed;
    }
}
