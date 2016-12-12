package io.gametrack.competition.web;

import io.gametrack.player.Gender;
import io.gametrack.player.Player;

/**
 * @author Kevin Sutton
 */
public class PlayerDTO {
    private Long id;
    private String name;
    private Gender gender;

    public PlayerDTO(Player player) {
        this.id = player.getId();
        this.name = player.getFullName();
        this.gender = player.getGender();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
