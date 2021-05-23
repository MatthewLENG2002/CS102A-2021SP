package cs102a.util;

import cs102a.Info;
import cs102a.StatusMap;
import cs102a.gui.GameBoard;
import cs102a.saver.GameSaver;

import javax.swing.*;
import java.util.Stack;

public class GameWithdraw {
    public static Stack stack = new Stack();

    int xLocation;
    int yLocation;
    int[] tempplayerScore;
    int[] tempplayerFaults;
    int temproundLeftTime;
    int tempmineLeft;
    int[][] tempstatusmap;


    public GameWithdraw(int x,int y){
        tempstatusmap = new int[StatusMap.statusmap.length][StatusMap.statusmap[0].length];
        tempplayerScore = new int[]{Info.playerScore[0], Info.playerScore[1]};
        tempplayerFaults = new int[]{Info.playerFaults[0],Info.playerFaults[1]};
        temproundLeftTime = Info.roundLeftTime;
        xLocation = x;
        yLocation = y;
        tempmineLeft = Info.mineLeft;
        for (int i = 0; i < StatusMap.statusmap.length; i++) {
            for (int j = 0; j < StatusMap.statusmap[0].length; j++) {
                tempstatusmap[i][j] = StatusMap.statusmap[i][j];
            }
        }
//        tempstatusmap = StatusMap.statusmap;
    }

    public static void push(int x,int y){
        stack.push(new GameWithdraw(x,y));
    }

    public static void pop(GameBoard g){
        if (stack.empty()){
            JDialog emptyStack = new JDialog();
            emptyStack.setVisible(true);
            emptyStack.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            emptyStack.setLocationRelativeTo(null);
            emptyStack.setSize(200, 100);
            JLabel tip = new JLabel("You've reach the first step!",JLabel.CENTER);
            tip.setVisible(true);
            emptyStack.add(tip);
        }
        else {
            GameWithdraw lastStep = (GameWithdraw)stack.pop();
//            StatusMap.cover(lastStep.xLocation,lastStep.yLocation);
            Info.playerScore = lastStep.tempplayerScore;
            Info.playerFaults = lastStep.tempplayerFaults;
            Info.mineLeft = lastStep.tempmineLeft;
            Info.roundLeftTime = lastStep.temproundLeftTime;
            StatusMap.statusmap = lastStep.tempstatusmap;

            try {
                GameSaver.replaySave();
            } catch (Exception ioException) {}
            g.infoPanel.refresh(g);
            g.refresh();
        }
    }

    public static void empty(){
        while(!stack.empty()){
            stack.pop();
        }
    }
}
