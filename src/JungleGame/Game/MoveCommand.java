package JungleGame.Game;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public class MoveCommand extends GameCommand {

    // TODO: Implement execute()
    public MoveCommand(int fromX, int fromY, int toX, int toY) {
        super(fromX, fromY, toX, toY);
    }

    @Override
    public boolean execute(Board board) {
        Command command;

        // Check player
        Cell fromCell = board.getCell(fromX, fromY);
        if (Game.getCurPlayer() != fromCell.getAnimal().getOwner()) {
            command = new InvalidCommand();
            return command.execute(board);
        }

        // Check jump
        if (Math.abs(toX - fromX) != 1 && Math.abs(fromY - toY) != 1) {
            command = new JumpCommand(fromX, fromY, toX, toY);
            return command.execute(board);
        }

        // General case
        Cell toCell = board.getCell(toX, toY);
        switch (toCell.getProperty()) {
            case TRAP:
                command = new MoveToTrapCommand(fromX, fromY, toX, toY);
                break;
            case DEN:
                command = new MoveToDenCommand(fromX, fromY, toX, toY);
                break;
            case RIVER:
                command = new MoveToRiverCommand(fromX, fromY, toX, toY);
                break;
            case LAND:
                command = new MoveToLandCommand(fromX, fromY, toX, toY);
                break;
            default:
                command = new InvalidCommand();
        }
        return command.execute(board);
    }
}
