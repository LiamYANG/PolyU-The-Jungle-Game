package JungleGame.Game;

/**
 * Created by Douglas Liu on 5/4/2018.
 */
public class JumpCommand extends MoveCommand {
    public JumpCommand(int fromX, int fromY, int toX, int toY) {
        super(fromX, fromY, toX, toY);
    }

    @Override
    public boolean execute(Board board) {
        // TODO: Implement here
        return true;
    }
}
