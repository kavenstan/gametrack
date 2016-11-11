package io.gametrack.competition.model;

import io.gametrack.competition.service.LeagueScoreService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin Sutton
 */
public class LeagueScore implements Comparable<LeagueScore> {
    private Entrant entrant;
    private LeagueGroup leagueGroup;

    private int leaguePoints = 0;
    private List<FixtureScore> fixtureScores = new ArrayList<>();

    public Entrant getEntrant() {
        return entrant;
    }

    public void setEntrant(Entrant entrant) {
        this.entrant = entrant;
    }

    public LeagueGroup getLeagueGroup() {
        return leagueGroup;
    }

    public void setLeagueGroup(LeagueGroup leagueGroup) {
        this.leagueGroup = leagueGroup;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public List<FixtureScore> getFixtureScores() {
        return fixtureScores;
    }

    public void setFixtureScores(List<FixtureScore> fixtureScores) {
        this.fixtureScores = fixtureScores;
    }

    @Override
    public int compareTo(LeagueScore o) {
        if (o.getLeaguePoints() - leaguePoints == 0) {
            int matchesWon = LeagueScoreService.matchesWon(this);
            int oMatchesWon = LeagueScoreService.matchesWon(o);
            if (oMatchesWon - matchesWon == 0) {
                int gamesWon = LeagueScoreService.gamesWon(this);
                int oGamesWon = LeagueScoreService.gamesWon(o);
                if (oGamesWon - gamesWon == 0) {
                    return LeagueScoreService.pointsWon(o) - LeagueScoreService.pointsWon(this);
                }
            }
            return oMatchesWon - matchesWon;
        }
        return o.getLeaguePoints() - leaguePoints;
    }

}
