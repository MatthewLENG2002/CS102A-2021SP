package cs102a.agent;

import cs102a.Info;
import cs102a.gui.GameGUI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MineGrid extends JButton {
    int id;
    boolean isBomb;
    boolean isChecked;


    public MineGrid() {
        MouseListener lsn = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == java.awt.event.MouseEvent.BUTTON1) // 左键
                {
                    if (isBomb) Info.playerScore[GameGUI.turnCnt % 2]--;
                    else {
                        isChecked=true;
                        setIcon(new ImageIcon("src/"));
                    }
                } else if (e.getButton() == java.awt.event.MouseEvent.BUTTON3) // 右键
                {
                    
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                this.
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        }
    }
}
