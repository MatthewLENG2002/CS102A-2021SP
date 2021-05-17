package cs102a.gui;

import cs102a.Info;
import cs102a.gui.model.SmallGrid;
import cs102a.gui.model.TimeDialog;

import javax.swing.*;
import java.awt.*;

public class RoundChooser extends JFrame{
    public RoundChooser(){
        JTextField round;
        JButton confirm;

        JLabel title = new JLabel("RoundChooser", JLabel.CENTER);
        title.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 50));
        title.setForeground(Color.BLACK);
        title.setOpaque(false);
        add(title);

        JLabel roundDetail = new JLabel("Enter round between 1-5:", JLabel.CENTER);
        title.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 25));
        title.setForeground(Color.BLACK);
        title.setOpaque(false);
        add(roundDetail);

        round = new JTextField();
        round.setEditable(true);
        add(round);

        confirm = new JButton("Confirm");
        add(confirm);
        confirm.addActionListener(e -> {
            int r =0;
            boolean isValid = true;
            try {
                r = Integer.parseInt(round.getText());
                if (!(r>=1 && r<=5)) throw new IllegalArgumentException("OutOfBounds!");
            } catch (NumberFormatException ne) {
                new TimeDialog(this, "Please enter the right figure!", 3);
                isValid = false;
            } catch (IllegalArgumentException iae) {
                new TimeDialog(this, iae.getMessage(), 3);
                isValid = false;
            }
            if (!isValid){
                this.dispose();
                new RoundChooser();
            }
            else {
                Info.round = r;
                this.dispose();
                new GameBoard();
            }
        });

        setLayout(new GridLayout(4, 1, 2, 2));
        add(new SmallGrid(3, 1, title));
        add(new SmallGrid(3, 1, roundDetail));
        add(new SmallGrid(3, 3, round));
        add(new SmallGrid(3, 3, confirm));

        this.setSize(280, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }

}

