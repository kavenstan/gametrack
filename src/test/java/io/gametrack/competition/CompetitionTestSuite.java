package io.gametrack.competition;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Kevin Sutton
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
        ContestScoreViewTest.class,
        GameTest.class,
        WinConditionTest.class
})

public class CompetitionTestSuite {
}