package io.gametrack.player.team;

import io.gametrack.player.Gender;

/**
 * @author Kevin Sutton
 */
public class MensDoublesTeam extends DoublesTeam {

    public MensDoublesTeam() {
        super();
    }

    @Override
    public Gender getTeamGender() {
        return Gender.MALE;
    }
}
