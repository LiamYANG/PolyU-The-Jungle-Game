package JungleGame.Game;

import JungleGame.IO.*;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public class Player {
    // TODO: Implement necessary methods
    public Player(String name, int animalNum) {
        this.name = name;
        this.animalNum = animalNum;
        this.inputHandler = InputHandler.getInputHangler();
        this.outputHandler = OutputHandler.getOutputHandler();
    }

    public String getName() {
        return name;
    }

    public int getAnimalNum() {
        return animalNum;
    }

    void decreaseAnimalNum() {
        if (animalNum > 0) {
            --animalNum;
        }
        if (animalNum == 0) {
            Game.onWinnerFound();
        }
    }

    public Command getCommand() {
        return null;
    }

    private String name;
    private int animalNum;
    private InputHandler inputHandler;
    private OutputHandler outputHandler;
}
