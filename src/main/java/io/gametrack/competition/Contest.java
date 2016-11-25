package io.gametrack.competition;

import io.gametrack.player.Side;

import java.util.Date;

/**
 * @author Kevin Sutton
 */
public abstract class Contest {

    protected int [] scores;

    protected Side sideOne;
    protected Side sideTwo;
    protected Date startedAt;
    protected Date endedAt;

    protected ContestState state;

    protected Contest() {
        this.state = ContestState.CREATED;
    }


    public ContestState getState() {
        return state;
    }

    public void setSideOne(Side sideOne) {
        this.sideOne = sideOne;
    }

    public void setSideTwo(Side sideTwo) {
        this.sideTwo = sideTwo;
    }

    public void setSides(Side sideOne, Side sideTwo) {
        setSideOne(sideOne);
        setSideTwo(sideTwo);
    }

    protected int sideScoreIndex(Side side) {
        return side.equals(sideOne) ? 0 : 1;
    }

    public void start() {
        this.state = ContestState.IN_PROGRESS;
        this.startedAt = new Date();
    }

    protected void end() {
        this.endedAt = new Date();
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public Date getEndedAt() {
        return endedAt;
    }

    public abstract void incrementScore(Side side);
    protected abstract boolean winConditionsMet();

}
