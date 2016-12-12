package io.gametrack.player;

import io.gametrack.core.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Kevin Sutton
 */
@Entity
@Table(name = "player")
public class Player extends BaseEntity{

    private String givenName;
    private String familyName;

    private Gender gender;

    protected Player() {
    }

    public Player(String givenName, String familyName) {
        this.givenName = givenName;
        this.familyName = familyName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFullName() {
        return givenName + " " + familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
