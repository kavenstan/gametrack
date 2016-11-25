package io.gametrack.player;

/**
 * @author Kevin Sutton
 */
public class WomensDoubles extends LevelDoubles {
    protected final Gender gender = Gender.MALE;

    public WomensDoubles(Player playerOne, Player playerTwo) {
        super(playerOne, playerTwo);
    }

    @Override
    protected Gender getGender() {
        return gender;
    }

    @Override
    public void addPlayer(Player player) {

    }
}
