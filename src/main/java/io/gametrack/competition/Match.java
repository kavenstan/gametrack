package io.gametrack.competition;

import io.gametrack.player.Side;

import java.util.List;
import java.util.Optional;

/**
 * @author Kevin Sutton
 */
public class Match extends Contest {

    private Fixture fixture;
    private List<Game> games;

    public Match() {

    }

    public void setFixture(final Fixture fixture) {
        this.fixture = fixture;
    }

    public Optional<Fixture> getFixture() {
        return fixture != null ? Optional.of(fixture) : Optional.empty();
    }

    @Override
    public void incrementScore(Side side) {

    }

}
