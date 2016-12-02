package io.gametrack;

/**
 * @author Kevin Sutton
 */
public enum GametrackExceptionType {

    INVALID_GENDER(2001),
    PLAYER_LIMIT_REACHED(2002),

    CONTEST_INCOMPLETE(3001),
    INVALID_SCORE(3101),
    NO_WINNER(3102),

    INVALID_SCORE_SYSTEM(4001);

    final int errorCode;

    GametrackExceptionType(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}