package io.gametrack.competition.domain.entity;

import io.gametrack.core.model.BaseEntity;
import io.gametrack.player.Side;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * @author Kevin Sutton
 */
@MappedSuperclass
public abstract class Score extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="id_side")
    private Side side;

    private int score;

    public Score(Side side) {
        this.side = side;
        this.score = 0;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        this.score++;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void reset() {
        this.score = 0;
    }
}
