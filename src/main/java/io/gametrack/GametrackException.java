package io.gametrack;

/**
 * @author Kevin Sutton
 */
public class GametrackException extends RuntimeException {

    public GametrackException(GametrackExceptionType type, String extra) {
        super("[" + type.getErrorCode() + "] " + type.name() + " : " + extra);
    }

    public GametrackException(GametrackExceptionType type) {
        this(type, "");
    }

}
