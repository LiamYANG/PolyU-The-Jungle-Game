package JungleGame.Game;

import JungleGame.IO.OutputHandler;

/**
 * Created by Douglas Liu on 5/4/2018.
 */
public class MoveToTrapCommand extends MoveCommand {
    public MoveToTrapCommand(int fromX, int fromY, int toX, int toY) {
        super(fromX, fromY, toX, toY);
    }

    @Override
    public boolean execute(Board board) {
        board.moveAnimal(fromX, fromY, toX, toY);

        String name = board.getCell(toX, toY).getAnimal().getName();
        OutputHandler out = OutputHandler.getOutputHandler();
        out.printPrompt(name + " move to Trap.\n");

        return true;
    }
}
