package io.gametrack.entrant;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin Sutton
 */
public class Player {

    private static final Logger logger = LogManager.getLogger();

    private String givenName;
    private String familyName;
    private Gender gender;

    public Player(String givenName, String familyName) {
        logger.info("Creating player: [{} {}]", givenName, familyName);
        this.givenName = givenName;
        this.familyName = familyName;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
