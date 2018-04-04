package JungleGame.Game;

import java.util.ArrayList;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public class Board {
    // TODO: Add more necessary methods
    public Board() {
        //...
    }

    public int getWidth() {
        return cells.size();
    }

    public int getHeight() {
        return cells.get(0).size();
    }

    public Cell getCell(int row, int column) {
        return cells.get(row).get(column);
    }

    private ArrayList<ArrayList<Cell>> cells;
}
