package JungleGame.Game;

import JungleGame.IO.OutputHandler;

/**
 * Created by Douglas Liu on 9/4/2018.
 */
public class RatEatCommand extends EatCommand {
    public RatEatCommand(int fromX, int fromY, int toX, int toY) {
        super(fromX, fromY, toX, toY);
    }

    @Override
    public boolean execute(Board board) {
        Cell fromCell = board.getCell(fromX, fromY);
        Cell toCell = board.getCell(toX, toY);
        Animal eater = fromCell.getAnimal();
        Animal eatee = toCell.getAnimal();

        // Check Eat from River
        if (fromCell instanceof RiverCell && !(toCell instanceof RiverCell)) {
            Command command = new InvalidCommand();
            return command.execute(board);
        }

        // Check Eat towards River
        if (!(fromCell instanceof RiverCell) && toCell instanceof RiverCell) {
            Command command = new InvalidCommand();
            return command.execute(board);
        }

        if (eater.getRank() < eatee.getRank() && !(eatee instanceof Elephant) && !(toCell instanceof TrapCell)) {
            Command command = new InvalidCommand();
            return command.execute(board);
        }

        Command command = new MoveCommand(fromX, fromY, toX, toY);
        if (command.execute(board)) {
            OutputHandler out = OutputHandler.getOutputHandler();
            out.printPrompt(eater.getName() + " eats " + eatee.getName() + ".\n");
            return true;
        } else {
            return false;
        }
    }
}
