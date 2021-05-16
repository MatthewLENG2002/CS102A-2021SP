package cs102a.gui;

import cs102a.gui.model.SmallGrid;

import javax.swing.*;
import java.awt.*;

public class Settings extends JFrame {

    public static Settings settings=new Settings();

    public Settings(){
        super("Mine Sweeper");

        JLabel title = new JLabel("Settings", JLabel.CENTER);
        title.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 50));
        title.setForeground(Color.BLACK);
        title.setOpaque(false);

        JButton theme = new JButton("Theme");
        theme.setOpaque(false);
        theme.setBorder(null);
        theme.setForeground(Color.BLACK);
        theme.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        theme.addActionListener(e -> {

        });

        JButton rank = new JButton("Rank");
        rank.setOpaque(false);
        rank.setBorder(null);
        rank.setForeground(Color.BLACK);
        rank.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        rank.addActionListener(e -> {

        });

        JButton cheat = new JButton("Cheat");
        cheat.setOpaque(false);
        cheat.setBorder(null);
        cheat.setForeground(Color.BLACK);
        cheat.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        cheat.addActionListener(e -> {

        });

        JButton home = new JButton("Home");
        home.setOpaque(false);
        home.setBorder(null);
        home.setForeground(Color.BLACK);
        home.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        home.addActionListener(e -> {
            settings.setVisible(false);
            StartMenu.start.setVisible(true);
        });

        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        setLayout(new GridLayout(5, 1, 2, 2));
        add(title);
        add(new SmallGrid(3, 3, theme));
        add(new SmallGrid(3, 3, rank));
        add(new SmallGrid(3, 3, cheat));
        add(new SmallGrid(3, 3, home));


    }
}



