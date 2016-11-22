package io.gametrack.simulation;

import io.gametrack.entrant.Entrant;
import io.gametrack.entrant.Player;

import java.util.OptionalDouble;
import java.util.Random;

/**
 * @author Kevin Sutton
 */
public class Utils {

    public static String randomString(final String[] elements) {
        return elements[(int) Math.floor(Math.random() * elements.length)];
    }

    public static double playerRating(Player player) {
        Random r = new Random(player.getFullName().hashCode());
        return r.nextDouble();
    }

    public static Double entrantRating(Entrant entrant) {
        return entrant.getPlayers().stream().mapToDouble(Utils::playerRating).average().getAsDouble();
    }

    public static boolean isWinner(Entrant entrant, Entrant opponent) {
        return entrantRating(entrant) > entrantRating(opponent);
    }

}
