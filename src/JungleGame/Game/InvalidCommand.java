package JungleGame.Game;

import JungleGame.IO.OutputHandler;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public class InvalidCommand extends Command {
    @Override
    public boolean execute(Board board) {
        OutputHandler.getOutputHandler().printPrompt("Invalid command.\n");
        return false;
    }
}
