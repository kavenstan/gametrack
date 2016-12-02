package io.gametrack;

import io.gametrack.competition.CompetitionTestSuite;
import io.gametrack.score.validation.ScoreTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Kevin Sutton
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
        CompetitionTestSuite.class,
        ScoreTestSuite.class
})
public class GametrackTestSuite {

}