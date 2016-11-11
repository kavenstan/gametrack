package io.gametrack.competition.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Group of entrants in a league.
 *
 * @author Kevin Sutton
 */
public class LeagueGroup {

    private List<LeagueScore> leagueScores = new ArrayList<>();
    private List<Fixture> fixtures = new ArrayList<>();

    public List<LeagueScore> getLeagueScores() {
        return leagueScores;
    }

    public LeagueScore leagueScore(Entrant entrant) {
        return leagueScores.stream().filter(s -> s.getEntrant().equals(entrant)).findFirst().get();
    }

    public void add(Entrant entrant) {
        LeagueScore score = new LeagueScore();
        score.setLeagueGroup(this);
        score.setEntrant(entrant);
        leagueScores.add(score);
    }

    public List<LeagueScore> getStandings() {
        Collections.sort(leagueScores);
        return leagueScores;
    }
}
