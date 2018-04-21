package JungleGame.Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public class Board {
    public static void main(String args[]) throws IOException {
        Board b = new Board();
        b.load("C:\\Users\\1\\Desktop\\SDP\\Project\\PolyU-The-Jungle-Game\\src\\1.txt");
    }

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
        try {
            BufferedReader br = new BufferedReader(new FileReader(loadFile));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            int lineNo = 0;

            // get the curentPlayerIndex
            int currentPlayer = Integer.parseInt(line);

            //get the information of player0
            line = br.readLine();
            String player0Name = line.split(" ")[0];
            int play0NumAnimal = Integer.parseInt(line.split(" ")[1]);
            ArrayList<Player> playerArrayList = new ArrayList<Player>();
            playerArrayList.add(new Player(player0Name,play0NumAnimal));

            //get the information of player1
            line = br.readLine();
            String player1Name = line.split(" ")[0];
            int play1NumAnimal = Integer.parseInt(line.split(" ")[1]);
            playerArrayList.add(new Player(player1Name,play1NumAnimal));

            line = br.readLine();
            int row = Integer.parseInt(line.split(" ")[0]);
            int column = Integer.parseInt(line.split(" ")[1]);
            ArrayList<ArrayList<Cell>> cells = new ArrayList<ArrayList<Cell>>();
            for(int i = 0; i < row; i++){
                line = br.readLine();
                cells.add(new ArrayList<Cell>());
                for(int j = 0; j < column; j++){
                    switch(line.split(" ")[0]){
                        case("LAND"):

                    }
                }
            }


            return true;
        }
        catch (IOException e){
            System.out.println(e.fillInStackTrace());
            return false;
        }

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
