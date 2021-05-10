package cs102a.gui.model;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    Image img;

    public BackgroundPanel(Image img) {
        this.img = img;
        this.setOpaque(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}