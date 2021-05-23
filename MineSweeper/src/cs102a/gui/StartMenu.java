package cs102a.gui;

import cs102a.Info;
import cs102a.gui.model.BackgroundPanel;
import cs102a.gui.model.SmallGrid;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class StartMenu extends JFrame {

    public static StartMenu start = new StartMenu();
    public BackgroundPanel bg = new BackgroundPanel();

    public StartMenu() {
        super("Mine Sweeper");
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("History\\Info.txt"));
            Info.playerPoints= (int[])ois.readObject();
        } catch (Exception e) { }

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
            start.setVisible(false);
            DifficultySelector ds = new DifficultySelector();
        });

        JButton loadGame = new JButton("Load History");
        loadGame.setOpaque(false);
        loadGame.setBorder(null);
        loadGame.setForeground(Color.BLACK);
        loadGame.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        loadGame.addActionListener(e -> {
            HistorySelector hs = new HistorySelector();
            hs.setVisible(true);
            start.setVisible(false);
        });

//        JButton storeButton = new JButton("Gadget Mall");
//        storeButton.setOpaque(false);
//        storeButton.setBorder(null);
//        storeButton.setForeground(Color.BLACK);
//        storeButton.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
//        storeButton.addActionListener(e -> {
//            Store st = new Store();
//            st.setVisible(true);
//            start.setVisible(false);
//        });

        JButton settingButton = new JButton("Settings");
        settingButton.setOpaque(false);
        settingButton.setBorder(null);
        settingButton.setForeground(Color.BLACK);
        settingButton.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        settingButton.addActionListener(e -> {
            Settings.settings.setVisible(true);
            start.setVisible(false);
        });

        JButton exit = new JButton("Exit");
        exit.setOpaque(false);
        exit.setBorder(null);
        exit.setForeground(Color.BLACK);
        exit.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        exit.addActionListener(e -> {
            int[] playerPointsRecorder = Info.playerPoints;
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("History\\Info.txt"));
                oos.writeObject(playerPointsRecorder);
            } catch (Exception ioException) {}
            this.dispose();
        });


        bg.setLayout(new GridLayout(4, 1, 2, 2));
        bg.add(new SmallGrid(3, 3, newGame));
        bg.add(new SmallGrid(3, 3, loadGame));
//        bg.add(new SmallGrid(3, 3, storeButton));
        bg.add(new SmallGrid(3, 3, settingButton));
        bg.add(new SmallGrid(3, 3, exit));

        this.add(bg);
        Info.bgPanel.add(bg);
        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }


    public static void main(String[] args) {
        StartMenu.start.setVisible(true);
    }


}
