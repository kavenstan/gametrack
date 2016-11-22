package io.gametrack.competition.service;

import io.gametrack.competition.model.League;
import io.gametrack.competition.model.LeagueGroup;
import io.gametrack.score.model.LeagueScore;

import java.util.List;

/**
 * @author Kevin Sutton
 */
public class LeaguePrinter {
    private League league;

    public LeaguePrinter(League league) {
        this.league = league;
    }
/*

    public void print() {
        System.out.println("League: " + league.getName());
        int count = 0;
        for (LeagueGroup group : league.getGroups()) {
            System.out.println("Group " + ++count);

            System.out.println(
                    leftPad("Team", 10) +
                    leftPad("Lg", 4) +
                    leftPad("Mat", 4) +
                    leftPad("Gms", 4) +
                    leftPad("Pts", 4)
            );

            List<LeagueScore> standings = group.getStandings();
            for(LeagueScore score : standings) {
                System.out.println(
                        leftPad(score.getEntrant().getName(), 10)  +
                        leftPad(score.getPoints() , 4) +
                        leftPad(ScoreService.fixturesWonInLeague(score.getFixtureScores().stream()) , 4) +
                        leftPad(ScoreService.gamesWon(score) , 4) +
                        leftPad(ScoreService.pointsWon(score), 4) );
            }

        }
    }
*/

    private String leftPad(int in, int size) {
        return leftPad(String.valueOf(in), size);
    }

    private String leftPad(String in, int size) {
        int zeroesNeeded = size - in.length();
        while(zeroesNeeded > 0) {
            in = " " + in;
            zeroesNeeded--;
        }
        return in;
    }
}
