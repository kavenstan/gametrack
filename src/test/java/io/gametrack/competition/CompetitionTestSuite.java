package io.gametrack.competition;

import io.gametrack.competition.domain.entity.GameTest;
import io.gametrack.competition.domain.entity.MatchTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Kevin Sutton
 */

@RunWith(Suite.class)

@Suite.SuiteClasses({
        GameTest.class,
        MatchTest.class
})
public class CompetitionTestSuite {

}
