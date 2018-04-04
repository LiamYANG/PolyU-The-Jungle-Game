package JungleGame.Game;

import JungleGame.IO.*;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public class Player {
    // TODO: Implement necessary methods
    public Player(String name) {
        this.name = name;
        this.inputHandler = InputHandler.getInputHangler();
        this.outputHandler = OutputHandler.getOutputHandler();
    }

    public String getName() {
        return name;
    }

    public Command getCommand() {
        return null;
    }

    private String name;
    private InputHandler inputHandler;
    private OutputHandler outputHandler;
}
