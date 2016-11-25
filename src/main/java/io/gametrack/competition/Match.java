package io.gametrack.competition;

import io.gametrack.player.Side;

import java.util.Optional;

/**
 * @author Kevin Sutton
 */
public class Match extends Contest {

    private Fixture fixture;

    public Optional<Fixture> getFixture() {
        return fixture != null ? Optional.of(fixture) : Optional.empty();
    }

    @Override
    public void setSideOne(Side sideOne) {

    }

    @Override
    public void setSideTwo(Side sideTwo) {

    }

    @Override
    public void incrementScore(Side side) {

    }

    @Override
    protected boolean winConditionsMet() {
        return false;
    }
}
