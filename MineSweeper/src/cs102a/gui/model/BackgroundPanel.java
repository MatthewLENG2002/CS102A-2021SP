package cs102a.gui.model;

import cs102a.Info;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    Image image;

    public BackgroundPanel(Image image) {
        this.image = image;
        this.setOpaque(false);
    }

    public BackgroundPanel() {
        this.image = new ImageIcon("images/" + Info.theme + ".JPG").getImage();
        this.setOpaque(false);
    }

    public static void updateAll(){
        for(BackgroundPanel bg:Info.bgPanel)
            bg.image = new ImageIcon("images/" + Info.theme + ".JPG").getImage();
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}