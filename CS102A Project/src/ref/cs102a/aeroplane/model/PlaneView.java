package ref.cs102a.aeroplane.model;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @apiNote 点击按键时会自动移动叠子，虽然他们是 invisible & disabled
 * 棋子移动到终点会自动解散叠子状态
 */
public class PlaneView extends JButton {

    //! 这个非常有用，多写几个用于不同状态的格子
    MouseListener ableToMoveTipListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        // 做个移入移出的可选择的提示，bonus
        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };

    public PlaneView(ChessBoard chessboard, int number, int color, int itsHangar, int xOffSet, int yOffSet, Aeroplane aeroplane) {
        // constructor
    }

    public void readyToBeSelected() {
        this.addMouseListener(ableToMoveTipListener);
        this.setEnabled(true);
    }

    @Override
    public void setEnabled(boolean flag) {
        if (!flag) {
            for (MouseListener m : this.getMouseListeners())
                this.removeMouseListener(m);
        }
    }
}
