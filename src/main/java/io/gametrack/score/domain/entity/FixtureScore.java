package io.gametrack.score.domain.entity;

import io.gametrack.competition.domain.entity.Fixture;
import io.gametrack.player.Side;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Kevin Sutton
 */
@Entity
@Table(name="score_fixture")
public class FixtureScore extends Score {

    @ManyToOne
    @JoinColumn(name="id_fixture")
    private Fixture fixture;

    public FixtureScore(Side side) {
        super(side);
    }

    public Fixture getFixture() {
        return fixture;
    }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }
}