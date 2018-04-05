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
        // ...
    }
}
