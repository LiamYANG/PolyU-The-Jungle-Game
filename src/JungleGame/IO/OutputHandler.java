package JungleGame.IO;

import JungleGame.Game.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public class OutputHandler {
    // TODO: Implement with Singleton pattern
    private static int cellWidth=20;
    private static int textSize=5;
    private static JFrame f=new JFrame("The Jungle Game");
    private OutputHandler(){
        f.setVisible(false);
    }
    public static OutputHandler getOutputHandler() {
        return null;
    }

    public void draw(Board board) {
        int i,j;
        int isTop,isLeft,isBottom,isRight;
        f.removeAll();
        for(i=0;i<board.getWidth();i++){
            for(j=0;j<board.getHeight();j++){
                isTop=(i==0?1:0);
                isLeft=(j==0?1:0);
                isBottom=(i==(board.getHeight()-1)?1:0);
                isRight=(i==(board.getWidth()-1)?1:0);
                JLabel l = new JLabel();
                l.setSize(cellWidth,cellWidth);
                l.setLocation(i*cellWidth+10,j*cellWidth);
                if(board.getCell(i,j).getAnimal()!=null) {
                    l.setText(board.getCell(i, j).getAnimal().getName());
                    l.setHorizontalTextPosition(SwingConstants.CENTER);
                    l.setVerticalTextPosition(SwingConstants.CENTER);
                    l.setFont(new Font("Serif", Font.BOLD, textSize));
                    //set the text color
                    //animals of the current player is printed in black while the others in lightGray
                    if (board.getCell(i, j).getAnimal().getOwner().equals(Game.getCurPlayer())) {
                        l.setForeground(Color.black);
                    } else {
                        l.setForeground(Color.lightGray);
                    }
                }
                //set the background color
                if(board.getCell(i,j) instanceof LandCell){
                    l.setBackground(Color.white);
                }
                else if (board.getCell(i,j) instanceof RiverCell){
                    l.setBackground(Color.cyan);
                }
                else if(board.getCell(i,j) instanceof TrapCell){
                    l.setBackground(Color.red);
                }
                else if(board.getCell(i,j) instanceof DenCell) {
                    l.setBackground(Color.orange);
                }
                l.setOpaque(true);
                l.setBorder(BorderFactory.createMatteBorder(isTop,isLeft,isBottom,isRight,Color.red));
                f.add(l);
            }
        }
        JLabel l = new JLabel();
        l.setText(Game.getCurPlayer().getName()+"'s turn");
        l.setFont(new Font("Serif", Font.BOLD, textSize));
        l.setForeground(Color.black);
        l.setLocation(board.getHeight()*cellWidth,board.getWidth()*cellWidth/2);
        f.add(l);
        this.f.setSize(board.getWidth()*cellWidth+20,board.getHeight()*cellWidth+20);
        this.f.setVisible(true);
        f.repaint();
    }
    public void printPrompt(String s) {
        // no need to have new line
    }
}
