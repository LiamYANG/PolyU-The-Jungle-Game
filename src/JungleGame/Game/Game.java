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
        board.load("src\\test.txt");

        System.out.println(board.getCell(0,0).getAnimal());
        System.out.println(board.getCell(0,1).getAnimal());
        System.out.println(board.getCell(0,2).getAnimal());

        GameCommand command = new GameCommand(0,0,0,1);
        command.execute(board);

        System.out.println(board.getCell(0,0).getAnimal());
        System.out.println(board.getCell(0,1).getAnimal());
        System.out.println(board.getCell(0,2).getAnimal());
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
