package JungleGame.Game;

import JungleGame.IO.OutputHandler;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public class LoadCommand extends Command {
    public LoadCommand(String loadFile) {
        this.loadFile = loadFile;
    }

    @Override
    public void execute(Board board) {
        OutputHandler out = OutputHandler.getOutputHandler();

        if (board.load(loadFile)) {
            out.printPrompt("Game loaded.\n");
        } else {
            out.printPrompt("Fail to load.\n");
        }
    }

    private String loadFile;
}
