package io.gametrack.player;

import io.gametrack.GametrackException;
import io.gametrack.GametrackExceptionType;

/**
 * @author Kevin Sutton
 */
public class MixedDoubles extends Doubles {

    public MixedDoubles(Player playerOne, Player playerTwo) {
        super(playerOne, playerTwo);
        if (playerOne.getGender().equals(playerTwo.getGender())) {
            throw new GametrackException(GametrackExceptionType.INVALID_GENDER, "Can not add two of same gender to mixed team.");
        }
    }

    @Override
    public void addPlayer(Player player) {

    }

}
