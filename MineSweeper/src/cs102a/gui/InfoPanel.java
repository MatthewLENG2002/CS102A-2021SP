package cs102a.gui;

import cs102a.Info;
import cs102a.gui.GameBoard;
import cs102a.saver.GameSaver;
import cs102a.util.PlayerSwitch;
import cs102a.gui.model.SmallGrid;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InfoPanel extends JPanel {

    JLabel player1;
    JLabel player2;
    JLabel player1Score;
    JLabel player2Score;
    JLabel player1Faults;
    JLabel player2Faults;
    JLabel remainingMine;
    JLabel time;

    public ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();


    public InfoPanel(GameBoard g) {

        JPanel detailInfoPanel = new JPanel();
        JPanel basicInfoPanel = new JPanel();

        /////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////

        ses.scheduleAtFixedRate(() -> {
            Info.roundLeftTime--;
            if (Info.roundLeftTime == -1) {
                Info.roundLeftTime = 10;
                Info.roundNow++;
                try {
                    GameSaver.replaySave();
                } catch (Exception ioException) {}
            }
            PlayerSwitch.playerSwitch();
            InfoPanel.this.refresh(g);
        }, 1, 1, TimeUnit.SECONDS);

        /////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////


        this.setLayout(new GridLayout(2, 1));
        this.setVisible(true);

        detailInfoPanel.setLayout(new GridLayout(2, 3));
        detailInfoPanel.setVisible(true);
        this.add(detailInfoPanel);

        player1 = new JLabel("Player1", JLabel.CENTER);
        player1.setVisible(true);
        player1.setOpaque(true);
        player1.setBackground(Color.GRAY);
        detailInfoPanel.add(player1);
        player1Score = new JLabel("Score: " + Info.playerScore[0], JLabel.CENTER);
        player1Score.setVisible(true);
        detailInfoPanel.add(player1Score);
//        JTextField player1Score = new JTextField(Info.playerScore[0]);
//        player1Score.setVisible(true);
//        detailInfoPanel.add(player1Score);
        player1Faults = new JLabel("Faults: " + Info.playerFaults[0], JLabel.CENTER);
        player1Faults.setVisible(true);
        detailInfoPanel.add(player1Faults);
//        JTextField player1Faults = new JTextField(Info.playerFaults[0]);
//        player1Faults.setVisible(true);
//        detailInfoPanel.add(player1Faults);

        player2 = new JLabel("Player2", JLabel.CENTER);
        player2.setVisible(true);
        player2.setOpaque(true);
        player2.setBackground(Color.GRAY);
        detailInfoPanel.add(player2);
        player2Score = new JLabel("Score: " + Info.playerScore[1], JLabel.CENTER);
        player2Score.setVisible(true);
        detailInfoPanel.add(player2Score);
//        JTextField player2Score = new JTextField(Info.playerScore[1]);
//        player2Score.setVisible(true);
//        detailInfoPanel.add(player2Score);
        player2Faults = new JLabel("Faults: " + Info.playerFaults[1], JLabel.CENTER);
        player1Faults.setVisible(true);
        detailInfoPanel.add(player2Faults);
//        JTextField player2Faults = new JTextField(Info.playerFaults[1]);
//        player1Faults.setVisible(true);
//        detailInfoPanel.add(player2Faults);

        basicInfoPanel.setLayout(new GridLayout(1, 4));
        basicInfoPanel.setVisible(true);
        this.add(basicInfoPanel);

        remainingMine = new JLabel("Mine: " + Info.mineLeft, JLabel.CENTER);
        remainingMine.setVisible(true);
        basicInfoPanel.add(remainingMine);
//        JTextField remainingMineNumber = new JTextField(Info.mineLeft);
//        remainingMine.setVisible(true);
//        basicInfoPanel.add(remainingMineNumber);
        time = new JLabel("Time: " + Info.roundLeftTime + "s", JLabel.CENTER);
        time.setVisible(true);
        basicInfoPanel.add(time);
//        JTextField timeUsage = new JTextField("0");
//        timeUsage.setVisible(true);
//        basicInfoPanel.add(timeUsage);
    }

    public void refresh(GameBoard g) {
        int winState = new PlayerSwitch().winRefresh();
        switch (winState) {
            case 0 -> {
                ses.shutdown();
                JDialog result = new JDialog();
                result.setLayout(new GridLayout(2, 1));
                result.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                result.setLocationRelativeTo(null);
                result.setSize(300, 180);
                result.setVisible(true);
                JLabel title = new JLabel("Draw!", JLabel.CENTER);
                title.setVisible(true);
                result.add(title);
                JButton confirm = new JButton("Confirm");
                confirm.setVisible(true);
                result.add(new SmallGrid(1, 3, confirm));
                confirm.addActionListener(e -> {
                    result.dispose();
//                    g.dispose();
//                    StartMenu.start.setVisible(true);

                });
//                JButton replay = new JButton("Replay");
//                replay.setVisible(true);
//                result.add(new SmallGrid(1, 3, replay));
//                replay.addActionListener(e -> {
//                    result.dispose();
//                    g.dispose();
////                    StartMenu.start.setVisible(true);
//                    new Replay();
//                });
            }
            case 1 -> {
                ses.shutdown();
                JDialog result = new JDialog();
                result.setLayout(new GridLayout(2, 1));
                result.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                result.setLocationRelativeTo(null);
                result.setSize(300, 180);
                result.setVisible(true);
                JLabel title = new JLabel("Player 1 Wins!", JLabel.CENTER);
                title.setVisible(true);
                result.add(title);
                JButton confirm = new JButton("Confirm");
                confirm.setVisible(true);
                result.add(new SmallGrid(1, 3, confirm));
                confirm.addActionListener(e -> {
                    result.dispose();
//                    g.dispose();
//                    StartMenu.start.setVisible(true);
                });
//                JButton replay = new JButton("Replay");
//                replay.setVisible(true);
//                result.add(new SmallGrid(1, 3, replay));
//                replay.addActionListener(e -> {
//                    result.dispose();
//                    g.dispose();
////                    StartMenu.start.setVisible(true);
//                    new Replay();
//                });
            }
            case 2 -> {
                ses.shutdown();
                JDialog result = new JDialog();
                result.setLayout(new GridLayout(2, 1));
                result.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                result.setLocationRelativeTo(null);
                result.setSize(300, 180);
                result.setVisible(true);
                JLabel title = new JLabel("Player 2 Wins!", JLabel.CENTER);
                title.setVisible(true);
                result.add(title);
                JButton confirm = new JButton("Confirm");
                confirm.setVisible(true);
                result.add(new SmallGrid(1, 3, confirm));
                confirm.addActionListener(e -> {
                    result.dispose();
//                    g.dispose();
//                    StartMenu.start.setVisible(true);
                });
//                JButton replay = new JButton("Replay");
//                replay.setVisible(true);
//                result.add(new SmallGrid(1, 3, replay));
//                replay.addActionListener(e -> {
//                    result.dispose();
//                    g.dispose();
////                    StartMenu.start.setVisible(true);
//                    new Replay();
//                });
            }
            case -1 -> {
            }
        }
        if (Info.playerNow == 1) {
            this.player1.setBackground(Color.RED);
            this.player2.setBackground(Color.GRAY);
        } else if (Info.playerNow == 2) {
            this.player2.setBackground(Color.RED);
            this.player1.setBackground(Color.GRAY);
        }
        this.player1Score.setText("Score: " + Info.playerScore[0]);
        this.player1Faults.setText("Faults: " + Info.playerFaults[0]);
        this.player2Score.setText("Score: " + Info.playerScore[1]);
        this.player2Faults.setText("Faults: " + Info.playerFaults[1]);
        this.remainingMine.setText("Mine: " + Info.mineLeft);
        this.time.setText("Time: " + Info.roundLeftTime + "s");

    }
}
