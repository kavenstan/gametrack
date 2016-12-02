package io.gametrack.score.validation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Kevin Sutton
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestGameSettingScoreValidator.class,
        TestGameNoSettingScoreValidator.class
})
public class ScoreTestSuite {

}