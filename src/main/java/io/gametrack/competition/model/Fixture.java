package io.gametrack.competition.model;

import java.util.Date;

/**
 * @author Kevin Sutton
 */
public class Fixture {
    private Entrant entrantOne;
    private Entrant entrantTwo;
    private GameState state = GameState.SCHEDULED;
    private Entrant winner;
    private Date scheduledFor;

    public Entrant getEntrantOne() {
        return entrantOne;
    }

    public void setEntrantOne(Entrant entrantOne) {
        this.entrantOne = entrantOne;
    }

    public Entrant getEntrantTwo() {
        return entrantTwo;
    }

    public void setEntrantTwo(Entrant entrantTwo) {
        this.entrantTwo = entrantTwo;
    }

    public Entrant getWinner() {
        return winner;
    }

    public void setWinner(Entrant winner) {
        this.winner = winner;
    }

    public Date getScheduledFor() {
        return scheduledFor;
    }

    public void setScheduledFor(Date scheduledFor) {
        this.scheduledFor = scheduledFor;
    }
}
