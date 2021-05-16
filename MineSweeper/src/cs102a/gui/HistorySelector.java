package cs102a.gui;

import cs102a.gui.model.SmallGrid;

import javax.swing.*;
import java.awt.*;

public class HistorySelector extends JFrame {

    public static HistorySelector hs = new HistorySelector();
    public HistorySelector() {
        super("Mine Sweeper");

        JLabel title = new JLabel("HistorySelector", JLabel.CENTER);
        title.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 50));
        title.setForeground(Color.BLACK);
        title.setOpaque(false);

        JButton slot1 = new JButton("Slot1");
        slot1.setOpaque(false);
        slot1.setBorder(null);
        slot1.setForeground(Color.BLACK);
        slot1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        slot1.addActionListener(e -> {

        });

        JButton slot2 = new JButton("Slot2");
        slot2.setOpaque(false);
        slot2.setBorder(null);
        slot2.setForeground(Color.BLACK);
        slot2.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        slot2.addActionListener(e -> {

        });

        JButton slot3 = new JButton("Slot3");
        slot3.setOpaque(false);
        slot3.setBorder(null);
        slot3.setForeground(Color.BLACK);
        slot3.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        slot3.addActionListener(e -> {

        });

        JButton home = new JButton("Home");
        home.setOpaque(false);
        home.setBorder(null);
        home.setForeground(Color.BLACK);
        home.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        home.addActionListener(e -> {
            hs.setVisible(false);
            StartMenu.start.setVisible(true);
        });

        setLayout(new GridLayout(4, 1, 2, 2));
        add(new SmallGrid(3, 3, slot1));
        add(new SmallGrid(3, 3, slot2));
        add(new SmallGrid(3, 3, slot3));
        add(new SmallGrid(3, 3, home));

        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}
