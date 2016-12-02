package io.gametrack.score.validation;

import io.gametrack.GametrackException;
import io.gametrack.GametrackExceptionType;
import io.gametrack.competition.domain.entity.Contest;

/**
 * @author Kevin Sutton
 */
public class ScoreValidatorFactory {
    public static ScoreValidator getScoreValidator(Contest contest) {
        switch (contest.getScoreSystem()) {
            case GAME_WITH_SETTING:
                return new GameSettingScoreValidator();
            case GAME_NO_SETTING:
                return new GameNoSettingScoreValidator();
            case MATCH_BEST_OF_THREE_GAMES:
                return new MatchBestOfThreeScoreValidator();
            case MATCH_TWO_GAMES:
                break;
            case MATCH_SINGLE_GAME:
                break;
        }
        throw new GametrackException(GametrackExceptionType.INVALID_SCORE_SYSTEM);
    }
}
