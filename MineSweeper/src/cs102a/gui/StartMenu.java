package cs102a.gui;

import javax.swing.*;
import java.awt.*;

public class StartMenu extends JFrame {

    public static StartMenu start = new StartMenu();

    public StartMenu() {
        super("Mine Sweeper");

        JLabel title = new JLabel("Mine Sweeper", JLabel.CENTER);
        title.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 50));
        title.setForeground(Color.BLACK);
        title.setOpaque(false);

        JButton newGame = new JButton("New Game");
        newGame.setOpaque(false);
        newGame.setBorder(null);
        newGame.setForeground(Color.BLACK);
        newGame.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        newGame.addActionListener(e -> {
            GameGUI game = new GameGUI();
            game.setVisible(true);
            game.start();
        });

        JButton loadGame = new JButton("Load History");
        loadGame.setOpaque(false);
        loadGame.setBorder(null);
        loadGame.setForeground(Color.BLACK);
        loadGame.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        loadGame.addActionListener(e -> {
            HistorySelector hs = new HistorySelector();
            hs.setVisible(true);
        });

        JButton storeButton = new JButton("Gadget Mall");
        storeButton.setOpaque(false);
        storeButton.setBorder(null);
        storeButton.setForeground(Color.BLACK);
        storeButton.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        storeButton.addActionListener(e -> {
            Store st = new Store();
            st.setVisible(true);
        });

        JButton settingButton = new JButton("Settings");
        settingButton.setOpaque(false);
        settingButton.setBorder(null);
        settingButton.setForeground(Color.BLACK);
        settingButton.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        settingButton.addActionListener(e -> {
            start.setVisible(false);
            Settings.settings.setVisible(true);
        });
    }

    public static void main(String[] args) {

    }


}
