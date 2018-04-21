package JungleGame.IO;

import JungleGame.Game.Board;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public class OutputHandler {

    private StringBuffer sb;

    private volatile static OutputHandler handler = null;

    // lazy initialization with one static field containing the only OutputHandler
    private OutputHandler() {
        sb = new StringBuffer();
    }

    // check if the handler is null, then create or use the current one to return to caller. use synchronization to maintain thread-safe
    public static OutputHandler getOutputHandler() {
        if (handler == null) {
            synchronized (OutputHandler.class) {
                if (handler == null) {
                    handler = new OutputHandler();
                }
            }
        }
        return handler;
    }

    public void draw(Board board) {

    }

    // print something
    public void printPrompt(String s) {
        // no need to have new line
        System.out.print(s);
    }
}
