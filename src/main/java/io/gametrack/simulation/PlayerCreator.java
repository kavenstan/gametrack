package io.gametrack.simulation;

import io.gametrack.player.Gender;
import io.gametrack.player.Player;

/**
 * @author Kevin Sutton
 */
public class PlayerCreator {

    private final static String [] maleGivenNames = {"Nathanial","Julius","Arlie","Warren","Sydney","Tyson","Rufus","Brent","Erik","Micah","Adalberto","Dana","Edmund","Jamaal","Ron","Johnny","Raphael","Alphonse","Jamal","Landon","Newton","Moses","Derek","Harold","Rayford","Wilmer","Fernando","Lamar","Winfred","Hugo","Ross","Wilton","Jerrod","Clinton","Nicolas","Asa","Mac","Davis","Michal","Sean","Graham","Basil","Cleveland","Vincenzo","Paris","Bob","Wes","Bernardo","Adam","Timothy"};
    private final static String [] femaleGivenNames = {"Shaniqua","Lavonne","Tanisha","Sheba","Claretta","Charline","Valorie","Kenyatta","Joy","Anabel","Colene","Shanita","Agnus","Tess","Kindra","Leisa","Petrina","Tyesha","Cristi","Milagro","Emelina","Pamila","Shizuko","Sherice","Donya","Georgette","Ericka","Jenifer","Nancy","Edith","Dannielle","Keena","Kesha","Clora","Tandra","Jannet","Oda","Edyth","Kala","Dori","Joana","Asley","Taunya","Mari","Sharika","Leonor","Tangela","Alexandria","Ardella","Shanda"};
    private final static String [] familyNames = {"Rincon","Colombo","Beals","Arrowood","Rask","Douglas","Kittle","Baginski","Johson","Bey","Truesdale","Darrigo","Dostie","Truluck","Kutz","Brodsky","Hight","Shroyer","Gills","Laver","Shirk","Wilber","Lauderback","Miller","Lighty","Pressey","Twomey","Gatlin","Patti","Ohanlon","Mazzella","Denver","Heyer","Badon","Boles","Arneson","Lukach","Fuerst","Lozano","Paolini","Almanzar","Tindal","Demma","Sheard","Gorney","Nicholes","Leroux","Bayliss","Engel","Peele"};

    public Player createPlayer() {

        Gender gender = Gender.MALE;
        final double rand = Math.random();
        if (rand > 0.5) {
            gender = Gender.FEMALE;
        }

        return createPlayer(gender);
    }

    public Player createPlayer(final Gender gender) {
        Player player = new Player(gender == Gender.MALE ? Utils.randomString(maleGivenNames) : Utils.randomString(femaleGivenNames), Utils.randomString(familyNames));
        player.setGender(gender);

        return player;
    }


}
