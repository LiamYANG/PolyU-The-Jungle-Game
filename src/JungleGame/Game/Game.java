package JungleGame.Game;

import java.util.ArrayList;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public class Game {
    public static void main() {
        // TODO: Put the final code here
        board = new Board();
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

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static void setPlayers(ArrayList<Player> players) {
        Game.players = players;
    }

    public static int getCurPlayerIndex() {
        return curPlayerIndex;
    }

    public static void setCurPlayerIndex(int curPlayerIndex) {
        Game.curPlayerIndex = curPlayerIndex;
    }
}
