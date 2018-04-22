package JungleGame.Game;

import JungleGame.IO.OutputHandler;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public class EatCommand extends GameCommand {
    public EatCommand(int fromX, int fromY, int toX, int toY) {
        super(fromX, fromY, toX, toY);
    }

    @Override
    public boolean execute(Board board) {
        // Check Enemy
        if (board.getCell(toX, toY).getAnimal().getOwner() == Game.getCurPlayer()) {
            Command command = new InvalidCommand();
            return command.execute(board);
        }

        Animal eater = board.getCell(fromX, fromY).getAnimal();

        // Check Elephant
        if (eater instanceof Elephant) {
            Command command = new ElephantEatCommand(fromX, fromY, toX, toY);
            return command.execute(board);
        }

        // Check Rat
        if (eater instanceof Rat) {
            Command command = new RatEatCommand(fromX, fromY, toX, toY);
            return command.execute(board);
        }

        // Normal eat
        Cell toCell = board.getCell(toX, toY);
        Animal eatee = toCell.getAnimal();

        if (eater.getRank() < eatee.getRank() && !(toCell instanceof TrapCell)) {
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
