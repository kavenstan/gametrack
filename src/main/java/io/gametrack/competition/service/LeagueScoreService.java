package io.gametrack.competition.service;

import io.gametrack.competition.model.FixtureScore;
import io.gametrack.competition.model.GameScore;
import io.gametrack.competition.model.LeagueScore;
import io.gametrack.competition.model.MatchScore;

/**
 * @author Kevin Sutton
 */
public class LeagueScoreService {
    public static int leaguePoints(LeagueScore score) {
        return score.getLeaguePoints();
    }

    public static int matchesWon(LeagueScore score) {
        return score.getFixtureScores().stream()
                .mapToInt(FixtureScore::getAmountMatchesWon)
                .sum();
    }

    public static int gamesWon(LeagueScore score) {
        return score.getFixtureScores().stream()
                .flatMap(fixture -> fixture.getMatchScores().stream())
                .mapToInt(MatchScore::getAmountGamesWon)
                .sum();
    }

    public static int pointsWon(LeagueScore score) {
        return score.getFixtureScores().stream()
                .flatMap(fixture -> fixture.getMatchScores().stream())
                .flatMap(match -> match.getGameScores().stream())
                .mapToInt(GameScore::getAmountPoints)
                .sum();
    }
}
