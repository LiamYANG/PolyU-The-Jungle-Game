package JungleGame.Game;

import JungleGame.IO.InputHandler;
import JungleGame.IO.OutputHandler;

import java.util.ArrayList;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public class Game {
    public static void main(String[] args) {
        InputHandler in = InputHandler.getInputHandler();
        OutputHandler out = OutputHandler.getOutputHandler();

        board = new Board();

        out.printPrompt("Welcome to the Jungle Game\n\n");

        out.printPrompt("Please enter the name of the first player:\n");
        players.get(0).setName(in.getString());
        out.printPrompt("\nPlease enter the name of the second player:\n");
        players.get(1).setName(in.getString());

        out.printPrompt("\nNow the game start!\n\n");

        Player curPlayer;
        Command command;

        out.draw(board);
        while (!isFinished) {
            curPlayer = getCurPlayer();

            out.printPrompt("Player " + curPlayer.getName() + ", please enter your command:\n");
            command = curPlayer.getCommand();
            out.printPrompt("\n");

            command.execute(board);
            out.draw(board);
            if (!isFinished) {
                nextPlayer();
            }
        }
        out.printPrompt("Winner is player " + getCurPlayer().getName() + "!!!");
    }

    public static Player getCurPlayer() {
        return players.get(curPlayerIndex);
    }

    static void nextPlayer() {
        curPlayerIndex = (curPlayerIndex + 1) % players.size();
    }

    static void onWinnerFound() {
        isFinished = true;
    }

    static ArrayList<Player> getPlayers() {
        return players;
    }

    static void setPlayers(ArrayList<Player> players) {
        Game.players = players;
    }

    static int getCurPlayerIndex() {
        return curPlayerIndex;
    }

    static void setCurPlayerIndex(int curPlayerIndex) {
        Game.curPlayerIndex = curPlayerIndex;
    }

    private static Board board;
    private static ArrayList<Player> players;
    private static int curPlayerIndex = 0;
    private static boolean isFinished = false;
}
