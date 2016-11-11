package io.gametrack;

import io.gametrack.competition.model.Fixture;
import io.gametrack.competition.model.FixtureScore;
import io.gametrack.competition.model.GameScore;
import io.gametrack.competition.model.League;
import io.gametrack.competition.model.LeagueGroup;
import io.gametrack.competition.model.LeagueScore;
import io.gametrack.competition.model.MatchScore;
import io.gametrack.competition.model.Team;
import io.gametrack.competition.service.LeaguePrinter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        League league = new League("Test League");
        LeagueGroup group = new LeagueGroup();

        for (int i = 0; i < 4; i++) {
            Team team = new Team("Team " + i);
            group.add(team);

            List<GameScore> gameScores = new ArrayList<>();
            GameScore gameScore = new GameScore();
            gameScore.setAmountPoints((int) (Math.random() * 21));
            gameScores.add(gameScore);

            List<MatchScore> matchScores = new ArrayList<>();
            MatchScore matchScore = new MatchScore();
            matchScore.setAmountGamesWon((int) (Math.random() * 2));
            matchScore.setGameScores(gameScores);
            matchScores.add(matchScore);

            List<FixtureScore> fixtureScores = new ArrayList<>();
            FixtureScore fixtureScore = new FixtureScore();
            fixtureScore.setAmountMatchesWon((int) (Math.random() * 7));
            fixtureScore.setMatchScores(matchScores);
            fixtureScores.add(fixtureScore);

            LeagueScore leagueScore = group.leagueScore(team);
            leagueScore.setLeaguePoints((int) (Math.random() * 14));
            leagueScore.setFixtureScores(fixtureScores);

        }

        LeagueScore leagueScore = new LeagueScore();
        leagueScore.setEntrant(group.getLeagueScores().get(0).getEntrant());

        FixtureScore fixtureScore = new FixtureScore();
        fixtureScore.setAmountMatchesWon(4);


        league.add(group);

        LeaguePrinter printer = new LeaguePrinter(league);
        printer.print();


    }
}
