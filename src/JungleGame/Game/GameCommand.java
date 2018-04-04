package JungleGame.Game;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public class GameCommand extends Command {
    public GameCommand(int fromX, int fromY, int toX, int toY) {
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
    }

    @Override
    public void execute(Board board) {
        Command command;
        Cell fromCell = board.getCell(fromX, fromY);
        Cell toCell = board.getCell(toX, toY);

        // Invalid command case
        if (fromCell == null || toCell == null || fromCell.getAnimal() == null) {
            command = new InvalidCommand();
            command.execute(board);
            return;
        }

        // Pure moving case
        if (toCell.getAnimal() == null) {
            command = new MoveCommand(fromX, fromY, toX, toY);
            command.execute(board);
            return;
        }

        // Moving and eating case
        command = new EatCommand(fromX, fromY, toX, toY);
        command.execute(board);
    }

    protected int fromX, fromY, toX, toY;
}
