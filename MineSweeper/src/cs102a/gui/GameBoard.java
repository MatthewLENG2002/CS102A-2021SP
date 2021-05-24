package cs102a.gui;

import cs102a.Info;
import cs102a.MineMap;
import cs102a.StatusMap;
import cs102a.gui.model.EQ;
import cs102a.saver.GameSaver;
import cs102a.util.GameWithdraw;


import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GameBoard extends JFrame {
    JPanel boardPanel = new JPanel();
//    InfoPanel infoPanel = new InfoPanel();
    public InfoPanel infoPanel ;
    EQ bgm;

    public GameBoard() {
        super("MineSweeper");
        GameWithdraw.empty();
        infoPanel = new InfoPanel(this);

        if (!Info.isHistory) {
            File scFilreDir = new File("Replay");
            File TrxFiles[] = scFilreDir.listFiles();
            for (File curFile : TrxFiles) {
                curFile.delete();
            }
            Info.playerScore = new int[]{0, 0};
            Info.playerFaults = new int[]{0, 0};
            Info.roundNow = 0;
            Info.roundLeftTime = 10;
            if (Info.level <= 3 && Info.level >= 0) {
                new StatusMap(new MineMap(Info.level).map);
            } else if (Info.level == 4) {
                new StatusMap(new MineMap(Info.level, Info.rowi, Info.coli, Info.minei).map);
            } else if (Info.level == 0) {
                this.dispose();
                new DifficultySelector();
            }
        } else {
            Info.isHistory = false;
        }


        this.setSize(Info.coli * 20, 20 + Info.rowi * 20 * 2);
        this.setMinimumSize(new Dimension(180, 360));
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new GridLayout(2, 1));

        //  BGM  //////////////////////////////////////////////////////////////////

        switch (Info.theme) {
            case 1, 2 -> bgm = EQ.bgm1;
            case 3, 4 -> bgm = EQ.bgm2;
        }
        bgm.play();

        //  BGM  //////////////////////////////////////////////////////////////////


        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);
        menubar.setVisible(true);

        JMenu menu1 = new JMenu("Options");
        JMenu menu2 = new JMenu("Gadgets");
        menubar.add(menu1);
        menubar.add(menu2);

        JMenuItem item1 = new JMenuItem("SaveGame");
        item1.addActionListener(e -> {
            JDialog nameSaveFile = new JDialog();
            nameSaveFile.setVisible(true);
            nameSaveFile.setDefaultCloseOperation(HIDE_ON_CLOSE);
            nameSaveFile.setSize(150, 150);
            nameSaveFile.setLayout(new GridLayout(3, 1));
            nameSaveFile.setLocationRelativeTo(null);

            JLabel title = new JLabel("HistoryName", JLabel.CENTER);
            title.setVisible(true);
            nameSaveFile.add(title);

            JTextField fileName = new JTextField();
            fileName.setVisible(true);
            nameSaveFile.add(fileName);

            JButton confirm = new JButton("Confirm");
            confirm.setVisible(true);
            nameSaveFile.add(confirm);
            confirm.addActionListener(e1 -> {
                nameSaveFile.dispose();
                if (fileName.getText() == null) {
                    try {
                        GameSaver.save();
                    } catch (Exception ioException) {
                        ioException.printStackTrace();
                        JDialog saveFailure = new JDialog();
                        saveFailure.setVisible(true);
                        saveFailure.setDefaultCloseOperation(HIDE_ON_CLOSE);
                        saveFailure.setSize(120, 100);
                        saveFailure.setLocationRelativeTo(null);
                        JLabel failed = new JLabel("Save Failed!", JLabel.CENTER);
                        saveFailure.add(failed);
                    }
                    JDialog saveSuccess = new JDialog();
                    saveSuccess.setVisible(true);
                    saveSuccess.setDefaultCloseOperation(HIDE_ON_CLOSE);
                    saveSuccess.setSize(120, 100);
                    saveSuccess.setLocationRelativeTo(null);
                    JLabel success = new JLabel("Save Success!", JLabel.CENTER);
                    saveSuccess.add(success);
                } else {
                    try {
                        GameSaver.saveWithName(fileName.getText());
                    } catch (Exception ioException) {
                        ioException.printStackTrace();
                        JDialog saveFailure = new JDialog();
                        saveFailure.setVisible(true);
                        saveFailure.setDefaultCloseOperation(HIDE_ON_CLOSE);
                        saveFailure.setSize(120, 100);
                        saveFailure.setLocationRelativeTo(null);
                        JLabel failed = new JLabel("Save Failed!", JLabel.CENTER);
                        saveFailure.add(failed);
                    }
                    JDialog saveSuccess = new JDialog();
                    saveSuccess.setVisible(true);
                    saveSuccess.setDefaultCloseOperation(HIDE_ON_CLOSE);
                    saveSuccess.setSize(120, 100);
                    saveSuccess.setLocationRelativeTo(null);
                    JLabel success = new JLabel("Save Success!", JLabel.CENTER);
                    saveSuccess.add(success);
                }

            });
        });
        JMenuItem item2 = new JMenuItem("Withdraw");
        item2.addActionListener(e -> {
            GameWithdraw.pop(this);
            this.refresh();
            this.infoPanel.refresh(this);
            menubar.updateUI();
        });
        JMenuItem item3 = new JMenuItem("Cheat");
        item3.addActionListener(e -> {
            JDialog cheatBoard = new JDialog();
            JPanel cheatPanel = new JPanel();
            cheatBoard.setSize(Info.coli * 20, Info.rowi * 20);
            cheatBoard.setVisible(true);
            cheatPanel.setLayout(new GridLayout(Info.rowi, Info.coli));
            cheatBoard.setDefaultCloseOperation(HIDE_ON_CLOSE);
            for (int i = 0; i < MineMap.map.length; i++) {
                for (int j = 0; j < MineMap.map[0].length; j++) {
                    GameSquare tempSquare2 = new GameSquare(i + 1, j + 1, true);
                    cheatPanel.add(tempSquare2);
                    tempSquare2.setVisible(true);
                }
            }
            cheatBoard.add(cheatPanel);
        });

        JMenuItem item3p = new JMenuItem("Mute BGM");
        item3p.addActionListener(e -> {
            if (bgm.changeIsMute()) item3p.setText("Play BGM");
            else item3p.setText("Mute BGM");
        });


        JMenuItem item4 = new JMenuItem("Home");
        item4.addActionListener(e -> {
            try {
                GameSaver.save();
            } catch (Exception ioException) {
                ioException.printStackTrace();
                JDialog saveFailure = new JDialog();
                saveFailure.setVisible(true);
                saveFailure.setDefaultCloseOperation(HIDE_ON_CLOSE);
                saveFailure.setSize(120, 100);
                saveFailure.setLocationRelativeTo(null);
                JLabel failed = new JLabel("Save Failed!", JLabel.CENTER);
                saveFailure.add(failed);
            }
            this.bgm.stop();
            this.infoPanel.ses.shutdown();
            this.dispose();
//            GameBoard.this=null;
            System.gc();
            StartMenu.start.setVisible(true);
        });
        JMenuItem item5 = new JMenuItem("Gadget");
        item5.addActionListener(e -> {
            Info.roundLeftTime += 10;
        });
        JMenuItem item6 = new JMenuItem("ResetBoard");
        item6.addActionListener(e -> {
            Info.playerScore = new int[]{0, 0};
            Info.playerFaults = new int[]{0, 0};
            Info.roundNow = 0;
            Info.roundLeftTime = 10;
            Info.mineLeft = Info.minei;
            for (int i = 0; i < MineMap.map.length; i++) {
                for (int j = 0; j < MineMap.map[0].length; j++) {
                    StatusMap.statusmap[i][j] = 0;
                }
            }
            infoPanel.refresh(this);
            refresh();
            GameWithdraw.empty();
        });
        JMenuItem item7 = new JMenuItem("Restart");
        item7.addActionListener(e -> {
            new GameBoard();
            this.dispose();
        });

        menu1.add(item1);
        menu1.addSeparator();
        menu1.add(item2);
        menu1.addSeparator();
        menu1.add(item3);
        menu1.addSeparator();
        menu1.add(item3p);
        menu1.addSeparator();
        menu1.add(item4);
        menu2.add(item5);
        menu2.addSeparator();
        menu2.add(item6);
        menu2.addSeparator();
        menu2.add(item7);

        boardPanel.setLayout(new GridLayout(Info.rowi, Info.coli));
        boardPanel.setVisible(true);
        this.add(boardPanel);

        for (int i = 0; i < MineMap.map.length; i++) {
            for (int j = 0; j < MineMap.map[0].length; j++) {
                GameSquare tempSquare = new GameSquare(i + 1, j + 1, this);
                boardPanel.add(tempSquare);
                tempSquare.setVisible(true);
            }
        }

        add(infoPanel);
        infoPanel.refresh(this);
//        new AutoRefresher().run(infoPanel);
        try {
            GameSaver.replaySave();
        } catch (Exception ioException) {}

    }


    public void refresh() {
        boardPanel.removeAll();
        for (int i = 0; i < MineMap.map.length; i++) {
            for (int j = 0; j < MineMap.map[0].length; j++) {
                GameSquare tempSquare = new GameSquare(i + 1, j + 1, this);
                boardPanel.add(tempSquare);
                tempSquare.setVisible(true);
            }
        }
    }
}

