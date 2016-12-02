package io.gametrack.competition.domain.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin Sutton
 */
public class Fixture extends Contest {
    private List<Match> matches;

    public Fixture() {
        super();
        this.matches = new ArrayList<>();
    }

    public List<Match> getMatches() {
        return matches;
    }
}
