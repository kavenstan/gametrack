package io.gametrack.player;

/**
 * @author Kevin Sutton
 */
public class Sides {
    private final Side sideOne;
    private final Side sideTwo;

    public Sides(Side sideOne, Side sideTwo) {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
    }

    public Side getSideOne() {
        return sideOne;
    }

    public Side getSideTwo() {
        return sideTwo;
    }
}
