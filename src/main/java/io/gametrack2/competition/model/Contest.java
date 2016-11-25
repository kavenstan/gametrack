package io.gametrack2.competition.model;

import io.gametrack.competition.ContestState;
import io.gametrack2.entrant.Entrant;
import io.gametrack2.score.model.Score;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kevin Sutton
 */
public abstract class Contest {

    protected static final Logger logger = LogManager.getLogger();

    protected Contest parent;
    protected ContestState state;
    protected Map<Entrant, Score> scores;
    protected Entrant winner;
    protected List<Contest> children;

    public Contest() {
        scores = new HashMap<>();
        state = ContestState.CREATED;
        children = new ArrayList<>();
    }

    public abstract Score calculateScore(Entrant entrant);
    public abstract void updateScores();
    public abstract void checkConditions();

    public ContestState getState() {
        return state;
    }

    public void setState(ContestState state) {
        this.state = state;
        if (state.getStateType().equals(ContestState.StateType.COMPLETE)) {
            updateParentScore();
        }
    }

    public List<Entrant> getEntrants() {
        return new ArrayList<>(scores.keySet());
    }

    public void addEntrant(Entrant entrant, Score score) {
        logger.debug("Adding [{}] to contest.", entrant.getName());
        scores.put(entrant, score);
    }

    public Score getScore(Entrant entrant) {
        return scores.get(entrant);
    }

    public void setScore(Entrant entrant, Score score) {
        scores.put(entrant, score);
    }

    public Map<Entrant, Score> getScores() {
        return scores;
    }

    public void setScores(Map<Entrant, Score> scores) {
        this.scores = scores;
    }

    public Contest getParent() {
        return parent;
    }

    public void setParent(Contest parent) {
        this.parent = parent;
        this.parent.getChildren().add(this);
    }

    public List<Contest> getChildren() {
        return children;
    }

    public void updateParentScore() {
        if (parent != null) {
            parent.updateScores();
        }
    }

    public Entrant getWinner() {
        return winner;
    }

    public void setWinner(Entrant winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        String buf = "Contest{" +
                "state=" + state +
                ", scores={";

        for (Entrant entrant : getEntrants()) {
            buf += entrant.getName() + " (" + getScore(entrant) + ") ";
        }

        buf += "}, winner={" + getWinner() + "} }";
        return buf;
    }
}
