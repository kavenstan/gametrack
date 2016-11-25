package io.gametrack.player;

/**
 * @author Kevin Sutton
 */
public class MensDoubles extends LevelDoubles {

    protected final Gender gender = Gender.MALE;

    public MensDoubles(Player playerOne, Player playerTwo) {
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
