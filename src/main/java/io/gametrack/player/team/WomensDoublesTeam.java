package io.gametrack.player.team;

import io.gametrack.player.Gender;

/**
 * @author Kevin Sutton
 */
public class WomensDoublesTeam extends DoublesTeam {

    public WomensDoublesTeam() {
        super();
    }

    @Override
    public Gender getTeamGender() {
        return Gender.FEMALE;
    }

}
