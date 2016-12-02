package io.gametrack.competition.domain.entity;

import io.gametrack.competition.domain.ContestState;
import io.gametrack.competition.domain.ScoreSystem;
import io.gametrack.core.model.BaseEntity;
import io.gametrack.player.Side;
import io.gametrack.score.ScorePair;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.List;
import java.util.Optional;

/**
 * @author Kevin Sutton
 */
@MappedSuperclass
public abstract class Contest extends BaseEntity {

    protected static final int SIDE_ONE = 0;
    protected static final int SIDE_TWO = 1;

    @ManyToOne
    @JoinColumn(name="id_winner")
    protected Side winner;

    @ManyToOne
    @JoinColumn(name="id_home_side")
    protected Side homeSide;

    @Enumerated(EnumType.STRING)
    protected ContestState state;

    @Enumerated(EnumType.STRING)
    protected ScoreSystem scoreSystem;

    protected Contest() { }

    public Optional<Side> getWinner() {
        return winner != null ? Optional.of(winner) : Optional.empty();
    }

    public void setWinner(Side winner) {
        this.winner = winner;
    }

    public Optional<Side> getHomeSide() {
        return homeSide != null ? Optional.of(homeSide) : Optional.empty();
    }

    public void setHomeSide(Side homeSide) {
        this.homeSide = homeSide;
    }

    public ContestState getState() {
        return state;
    }

    public void setState(ContestState state) {
        this.state = state;
    }

    public ScoreSystem getScoreSystem() {
        return scoreSystem;
    }

    public void setScoreSystem(ScoreSystem scoreSystem) {
        this.scoreSystem = scoreSystem;
    }

    protected abstract void setScore(final int side, final int newValue);

    public void setScoreOne(final int newValue) {
        setScore(SIDE_ONE, newValue);
    }

    public void setScoreTwo(final int newValue) {
        setScore(SIDE_TWO, newValue);
    }

    public void setScores(final int newScoreOne, final int newScoreTwo) {
        setScoreOne(newScoreOne);
        setScoreTwo(newScoreTwo);
    }

    public abstract List<? extends Score> getScores();

    public ScorePair getScorePair() {
        return new ScorePair(getScores().get(0).getScore(), getScores().get(1).getScore());
    }

    public void setScores(ScorePair scorePair) {
        setScores(scorePair.getScoreOne(), scorePair.getScoreTwo());
    }

}
