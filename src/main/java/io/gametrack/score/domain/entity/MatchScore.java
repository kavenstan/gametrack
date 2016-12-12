package io.gametrack.score.domain.entity;

import io.gametrack.competition.domain.entity.Match;
import io.gametrack.player.Side;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Kevin Sutton
 */
@Entity
@Table(name="score_match")
public class MatchScore extends Score {

    @ManyToOne
    @JoinColumn(name="id_match")
    private Match match;

    protected MatchScore() {}

    public MatchScore(Side side) {
        super(side);
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

}
