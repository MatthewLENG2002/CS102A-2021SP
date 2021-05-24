package cs102a.util;

import cs102a.Info;
import cs102a.MineMap;
import cs102a.StatusMap;
import cs102a.gui.GameSquare;
import cs102a.saver.HistoryLoader;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Replay {

    public ScheduledExecutorService replaySes = Executors.newSingleThreadScheduledExecutor();

    public Replay() {
        Info.isHistory = true;
        final int[] replayRoundsNow = {0};
        int lastRoundsRound = Info.roundNow;
//        GameBoard gReplay = new GameBoard();
        JDialog cheatBoard = new JDialog();
        cheatBoard.setLayout(new GridLayout(1, 1));
        JPanel cheatPanel = new JPanel();
        cheatBoard.setSize(Info.rowi *20, Info.coli *20);
        cheatBoard.setMinimumSize(new Dimension(200,200));
        cheatBoard.setResizable(false);
        cheatBoard.setVisible(true);
        cheatPanel.setLayout(new GridLayout(Info.rowi, Info.coli));
        cheatBoard.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        cheatPanel.setVisible(true);
        cheatBoard.add(cheatPanel);



        replaySes.scheduleAtFixedRate(()->{
            if (replayRoundsNow[0] == lastRoundsRound+1){
                Info.isHistory = false;
                replaySes.shutdown();
            }
            else{
                try {
                    HistoryLoader.loadReplay(replayRoundsNow[0]);
                    cheatPanel.removeAll();
//                    cheatBoard.remove(cheatPanel);
                    for (int j = 0; j < MineMap.map.length; j++) {
                        for (int k = 0; k < MineMap.map[0].length; k++) {
                            GameSquare tempSquare2 = new GameSquare(j + 1, k + 1,1, StatusMap.statusmap);
                            cheatPanel.add(tempSquare2);
                            tempSquare2.setVisible(true);
                        }
                    }
//                    cheatBoard.add(cheatPanel);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                replayRoundsNow[0]++;
                cheatPanel.updateUI();
            }

        }, 0, 1, TimeUnit.SECONDS);


    }
}

