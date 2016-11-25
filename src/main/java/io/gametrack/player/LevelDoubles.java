package io.gametrack.player;

import io.gametrack.GametrackException;
import io.gametrack.GametrackExceptionType;

/**
 * @author Kevin Sutton
 */
public abstract class LevelDoubles extends Doubles {

    public LevelDoubles(final Player playerOne, final Player playerTwo) {
        super(playerOne, playerTwo);
        if (!playerOne.getGender().equals(getGender()) ||
                !playerTwo.getGender().equals(getGender())) {
            throw new GametrackException(GametrackExceptionType.INVALID_GENDER, "Tried to initialise level doubles with wrong gender");
        }
    }

    protected abstract Gender getGender();

}
