package io.gametrack.competition.domain.entity;

import io.gametrack.score.domain.entity.FixtureScore;
import io.gametrack.score.domain.entity.Score;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin Sutton
 */
@Entity
@Table(name = "fixture")
public class Fixture extends Contest {

    @OneToMany(mappedBy = "fixture", fetch = FetchType.LAZY)
    private List<FixtureScore> scores;

    @OneToMany(mappedBy = "fixture", fetch = FetchType.LAZY)
    private List<Match> matches;

    protected Fixture() {
        super();
        this.matches = new ArrayList<>();
    }

    @Override
    public void setScore(int side, int newValue) {
        this.scores.get(side).setScore(newValue);
    }

    @Override
    public List<? extends Score> getScores() {
        return null;
    }

    public List<Match> getMatches() {
        return matches;
    }
}
