package cs102a.gui.model;

import javax.swing.*;
import java.awt.*;

public class SmallGrid extends JPanel {
    public SmallGrid(int row, int col, Object comp) {
        this.setLayout(new GridLayout(row, col));
        for (int i = 0; i < row * col; i++) {
            if (i == col * (row + 1) / 2 - col / 2 - 1) {
                this.add((Component) comp);
                continue;
            }
            this.add(new JLabel());
        }
    }
}
