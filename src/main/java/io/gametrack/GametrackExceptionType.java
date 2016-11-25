package io.gametrack;

/**
 * @author Kevin Sutton
 */
public enum GametrackExceptionType {
    INVALID_GENDER(2001),
    PLAYER_LIMIT_REACHED(2002),
    CONTEST_INCOMPLETE(3001);

    final int errorCode;

    GametrackExceptionType(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}