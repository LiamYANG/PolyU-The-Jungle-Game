package JungleGame.Game;

import JungleGame.IO.*;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public class Player {
    // TODO: Implement necessary methods
    public Player(String name, int numAnimal) {
        this.name = name;
        this.numAnimal = numAnimal;
        this.inputHandler = InputHandler.getInputHangler();
        this.outputHandler = OutputHandler.getOutputHandler();
    }

    public String getName() {
        return name;
    }

    public int getAnimalNum() {
        return numAnimal;
    }

    void decreaseAnimalNum() {
        if (numAnimal > 0) {
            --numAnimal;
        }
        if (numAnimal == 0) {
            Game.onWinnerFound();
        }
    }

    public Command getCommand() {
        return null;
    }

    private String name;
    private int numAnimal;
    private InputHandler inputHandler;
    private OutputHandler outputHandler;
}
