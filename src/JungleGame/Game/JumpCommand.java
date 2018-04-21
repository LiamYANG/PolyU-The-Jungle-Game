package JungleGame.Game;

import JungleGame.IO.OutputHandler;

/**
 * Created by Douglas Liu on 5/4/2018.
 */
public class JumpCommand extends MoveCommand {
    public JumpCommand(int fromX, int fromY, int toX, int toY) {
        super(fromX, fromY, toX, toY);
    }

    @Override
    public boolean execute(Board board) {
        // Check animal and cell
        Animal animal = board.getCell(fromX, fromY).getAnimal();
        Cell toCell = board.getCell(toX, toY);
        if (!(animal instanceof Tiger) && !(animal instanceof Lion) || (toCell instanceof RiverCell)) {
            Command command = new InvalidCommand();
            return command.execute(board);
        }

        // Check river between
        Cell tmp;
        if (fromX == toX) {
            for (int y = fromY + 1; y < toY; ++y) {
                tmp = board.getCell(fromX, y);
                if (!(tmp instanceof RiverCell) || tmp.getAnimal() != null) {
                    Command command = new InvalidCommand();
                    return command.execute(board);
                }
            }
        } else {
            for (int x = fromX; x < toX; ++x) {
                tmp = board.getCell(x, fromY);
                if (!(tmp instanceof RiverCell) || tmp.getAnimal() != null) {
                    Command command = new InvalidCommand();
                    return command.execute(board);
                }
            }
        }

        // Ok to jump
        board.moveAnimal(fromX, fromY, toX, toY);
        OutputHandler out = OutputHandler.getOutputHandler();
        out.printPrompt(animal.getName() + " move.\n");

        return true;
    }
}
