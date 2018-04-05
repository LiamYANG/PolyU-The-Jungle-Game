package JungleGame.Game;

import java.util.ArrayList;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public class Game {
    public static void main() {
        // TODO: Put the final code here
    }

    public static Player getCurPlayer() {
        return players.get(curPlayerIndex);
    }

    static void nextPlayer() {
        // TODO: Implement this
    }

    static void onWinnerFound() {
        // TODO: Implement this
    }

    private static Board board;
    private static ArrayList<Player> players;
    private static int curPlayerIndex;
}
