package JungleGame.Game;

import java.util.ArrayList;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public class Board {
    // TODO: Add and implement more necessary methods
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
        if (row < 0 || row > getWidth() || column < 0 || column > getHeight()) {
            return null;
        }
        return cells.get(row).get(column);
    }

    boolean save(String saveFile) {
        // return false when fails
        return true;
    }

    boolean load(String loadFile) {
        // return false when fails
        return true;
    }

    // below methods are only called by Command and Board itself
    void putAnimal(int row, int column, Animal animal) {
        Cell cell = getCell(row, column);
        cell.setAnimal(animal);
    }

    void removeAnimal(int row, int column) {
        Cell cell = getCell(row, column);
        cell.setAnimal(null);
    }

    void moveAnimal(int fromX, int fromY, int toX, int toY) {
        Animal animal = getCell(fromX, fromY).getAnimal();
        removeAnimal(fromX, fromY);
        putAnimal(toX, toY, animal);
    }

    private ArrayList<ArrayList<Cell>> cells;
    private Game game;
}
