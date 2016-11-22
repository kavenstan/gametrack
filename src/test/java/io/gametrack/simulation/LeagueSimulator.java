package io.gametrack.simulation;

import io.gametrack.competition.model.Contest;
import io.gametrack.competition.model.Fixture;
import io.gametrack.competition.model.FixtureType;
import io.gametrack.competition.model.Game;
import io.gametrack.competition.model.League;
import io.gametrack.competition.model.LeagueGroup;
import io.gametrack.competition.model.Match;
import io.gametrack.competition.model.enums.ContestState;
import io.gametrack.competition.model.enums.MatchType;
import io.gametrack.competition.service.FixtureGenerator;
import io.gametrack.competition.service.LeagueFixtureGenerator;
import io.gametrack.competition.service.MatchGenerator;
import io.gametrack.entrant.Doubles;
import io.gametrack.entrant.Entrant;
import io.gametrack.entrant.Gender;
import io.gametrack.entrant.Player;
import io.gametrack.entrant.Singles;
import io.gametrack.entrant.Team;
import io.gametrack.score.model.GameScore;
import io.gametrack.score.model.MatchScore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Kevin Sutton
 */
public class LeagueSimulator {

    private static final Logger logger = LogManager.getLogger();

    @Test
    public void runSimulation() {
        LeagueCreator leagueCreator = new LeagueCreator();

        League league = leagueCreator.createLeague("Test League");

        List<Fixture> allFixtures = addFixtures(league);

        addMatches(allFixtures);

        processFixtures(allFixtures);

    }

    private void processFixtures(List<Fixture> fixtures) {
        for (Fixture fixture : fixtures) {
            List<Entrant> teams = fixture.getEntrants();
            Team teamOne = (Team) teams.get(0);
            Team teamTwo = (Team) teams.get(1);
            for (Contest contest : fixture.getChildren()) {
                Match match = (Match) contest;
                addPlayers(match, teamOne);
                addPlayers(match, teamTwo);
                processMatch(match);
            }
            logger.debug(fixture);
        }
    }

    private void processMatch(Match match) {
        Entrant entrantOne = match.getEntrants().get(0);
        Entrant entrantTwo = match.getEntrants().get(1);

        while(match.getState().getStateType() != ContestState.StateType.COMPLETE) {
            Game game = new Game();
            game.setParent(match);
            game.addEntrant(entrantOne, new GameScore());
            game.addEntrant(entrantTwo, new GameScore());

            game.setState(ContestState.IN_PROGRESS);
            int loserScore = (int) Math.ceil(Math.random() * 19);

            if (Utils.isWinner(entrantOne, entrantTwo)) {
                game.setWinner(entrantOne);
                game.getScore(entrantOne).setValue(21);
                game.getScore(entrantTwo).setValue(loserScore);
            }
            else {
                game.setWinner(entrantTwo);
                game.getScore(entrantOne).setValue(loserScore);
                game.getScore(entrantTwo).setValue(21);
            }

            game.checkConditions();
            logger.debug(game);

        }
        logger.debug(match);
    }

    private void addPlayers(Match match, Team team) {
        Entrant entrant = null;
        switch(match.getMatchType()) {
            case MENS_SINGLES:
                entrant = new Singles();
                entrant.addPlayer(getPlayer(Gender.MALE, team));
                break;
            case WOMENS_SINGLES:
                entrant = new Singles();
                entrant.addPlayer(getPlayer(Gender.FEMALE, team));
                break;
            case MENS_DOUBLES:
                entrant = new Doubles();
                entrant.addPlayer(getPlayer(Gender.MALE, team));
                entrant.addPlayer(getPlayer(Gender.MALE, team));
                break;
            case WOMENS_DOUBLES:
                entrant = new Doubles();
                entrant.addPlayer(getPlayer(Gender.FEMALE, team));
                entrant.addPlayer(getPlayer(Gender.FEMALE, team));
                break;
            case MIXED_DOUBLES:
                entrant = new Doubles();
                entrant.addPlayer(getPlayer(Gender.MALE, team));
                entrant.addPlayer(getPlayer(Gender.FEMALE, team));
                break;
        }
        match.addEntrant(entrant, new MatchScore());
    }

    private Player getPlayer(Gender gender, Team team) {

        List<Player> players = team.getPlayers()
                .stream()
                .filter(p -> p.getGender().equals(gender))
                .collect(Collectors.toList());

        if (players.size() < 1) {
            throw new RuntimeException("No matching player found");
        }

        int rand = new Random().nextInt(players.size());
        return players.get(rand);

    }

    private List<Fixture> addFixtures(League league) {
        List<Fixture> allFixtures = new ArrayList<>();

        for (LeagueGroup group : league.getGroups()) {
            FixtureGenerator fixGen = new LeagueFixtureGenerator(group);
            allFixtures.addAll(fixGen.generateFixtures());
        }
        return allFixtures;
    }

    private void addMatches(List<Fixture> allFixtures) {
        for (Fixture fixture : allFixtures) {
            MatchGenerator matchGenerator = new MatchGenerator();
            matchGenerator.generateMatches(fixture);
        }
    }
}
