package cs102a.gui;

import cs102a.Info;
import cs102a.MineMap;
import cs102a.StatusMap;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame {
    JPanel boardPanel = new JPanel();

    public GameBoard() {
        super("MineSweeper");

        if (Info.level <= 3 && Info.level >= 0) {
            new StatusMap(new MineMap(Info.level).map);
        } else if (Info.level == 4) {
            new StatusMap(new MineMap(Info.level, Info.rowi, Info.coli, Info.minei).map);
        } else if (Info.level == 0) {
            this.dispose();
            new DifficultySelector();
        }


        this.setSize(Info.coli * 20, 30 + Info.rowi * 20);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);
        menubar.setVisible(true);

        JMenu menu1 = new JMenu("Options");
        JMenu menu2 = new JMenu("Gadgets");
        menubar.add(menu1);
        menubar.add(menu2);

        JMenuItem item1 = new JMenuItem("SaveGame");
        JMenuItem item2 = new JMenuItem("Withdraw");
        JMenuItem item3 = new JMenuItem("Cheat");
        item3.addActionListener(e -> {
            JFrame cheatBoard = new JFrame();
            JPanel cheatPanel = new JPanel();
            cheatBoard.setSize(Info.coli * 20, Info.rowi * 20);
            cheatBoard.setVisible(true);
            cheatPanel.setLayout(new GridLayout(Info.rowi, Info.coli));
            cheatBoard.setDefaultCloseOperation(EXIT_ON_CLOSE);
            for (int i = 0; i < MineMap.map.length; i++) {
                for (int j = 0; j < MineMap.map[0].length; j++) {
                    GameSquare tempSquare2 = new GameSquare(i + 1, j + 1, true);
                    cheatPanel.add(tempSquare2);
                    tempSquare2.setVisible(true);
                }
            }
            cheatBoard.add(cheatPanel);
        });


        JMenuItem item4 = new JMenuItem("Home");
        item4.addActionListener(e -> {
            this.dispose();
            StartMenu.start.setVisible(true);
        });
        JMenuItem item5 = new JMenuItem("Gadget 1");
        JMenuItem item6 = new JMenuItem("Gadget 2");

        menu1.add(item1);
        menu1.addSeparator();
        menu1.add(item2);
        menu1.addSeparator();
        menu1.add(item3);
        menu1.addSeparator();
        menu1.add(item4);
        menu2.add(item5);
        menu2.addSeparator();
        menu2.add(item6);

        boardPanel.setLayout(new GridLayout(Info.rowi, Info.coli));
        boardPanel.setVisible(true);
        this.add(boardPanel);

        for (int i = 0; i < MineMap.map.length; i++) {
            for (int j = 0; j < MineMap.map[0].length; j++) {
                GameSquare tempSquare = new GameSquare(i + 1, j + 1);
                boardPanel.add(tempSquare);
                tempSquare.setVisible(true);
            }
        }
    }

}

