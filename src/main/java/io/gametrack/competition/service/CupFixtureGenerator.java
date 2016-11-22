package io.gametrack.competition.service;

import io.gametrack.competition.model.Contest;
import io.gametrack.competition.model.Fixture;
import io.gametrack.entrant.Entrant;
import io.gametrack.score.model.FixtureScore;
import io.gametrack.score.model.Score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author Kevin Sutton
 */
public class CupFixtureGenerator implements FixtureGenerator {

    private Random randomGenerator;
    private List<Entrant> entrants;

    public CupFixtureGenerator(List<Entrant> entrants) {
        randomGenerator = new Random();
        this.entrants = entrants;
    }

    public List<Fixture> generateFixtures() {

        List<Fixture> fixtures = new ArrayList<>();

        int totalFixturesInFirstRound = fixturesInRound(entrants.size());

        int fixturesToPlayInFirstRound = entrants.size() - totalFixturesInFirstRound;

        for (int i = 0; i < fixturesToPlayInFirstRound; i++) {
            Fixture fixture = new Fixture();

            Map<Entrant, Score> scoreMap = new HashMap<>();
            scoreMap.put(pickRandomEntrant(entrants), new FixtureScore());
            scoreMap.put(pickRandomEntrant(entrants), new FixtureScore());
            fixture.setScores(scoreMap);

            fixtures.add(fixture);
        }

        return fixtures;
    }

    private int fixturesInRound(int amtEntrants) {
        return (int) Math.ceil(Math.log(amtEntrants)/Math.log(2)) / 2;
    }

    private Entrant pickRandomEntrant(List<Entrant> entrants) {
        int index = randomGenerator.nextInt(entrants.size());
        Entrant entrant = entrants.get(index);
        entrants.remove(entrant);
        return entrant;
    }

}
