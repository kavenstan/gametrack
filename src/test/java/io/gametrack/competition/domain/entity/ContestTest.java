package io.gametrack.competition.domain.entity;

import io.gametrack.player.Side;
import io.gametrack.player.Sides;

/**
 * @author Kevin Sutton
 */
public class ContestTest {

    protected final int SIDE_ONE = 0;
    protected final int SIDE_TWO = 1;

    protected Side sideOne;
    protected Side sideTwo;
    protected Sides sides;

    public void setUp() {
        this.sideOne = new Side();
        this.sideTwo = new Side();
        this.sides = new Sides(this.sideOne, this.sideTwo);
    }
}
