package JungleGame.Game;

import JungleGame.IO.OutputHandler;

/**
 * Created by Douglas Liu on 5/4/2018.
 */
public class MoveToRiverCommand extends MoveCommand {
    public MoveToRiverCommand(int fromX, int fromY, int toX, int toY) {
        super(fromX, fromY, toX, toY);
    }

    @Override
    public boolean execute(Board board) {
        Animal animal = board.getCell(fromX, fromY).getAnimal();

        // Check for rat
        if (!(animal instanceof Rat)) {
            Command command = new InvalidCommand();
            return command.execute(board);
        }

        board.moveAnimal(fromX, fromY, toX, toY);

        String name = board.getCell(toX, toY).getAnimal().getName();
        OutputHandler out = OutputHandler.getOutputHandler();
        out.printPrompt(name + " move to River.\n");

        return true;
    }
}
