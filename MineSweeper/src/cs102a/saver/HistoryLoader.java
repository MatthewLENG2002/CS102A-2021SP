package cs102a.saver;

import cs102a.Info;
import cs102a.MineMap;
import cs102a.StatusMap;
import cs102a.gui.GameBoard;

import java.io.*;

public class HistoryLoader {

    public static void load() throws Exception,IOException,ClassNotFoundException,FileNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("History\\History.txt"));

        Info.playerScore = (int[])ois.readObject();
        Info.playerFaults = (int[])ois.readObject();
        Info.playerPoints= (int[])ois.readObject();
        Info.rowi= (int)ois.readObject();
        Info.coli= (int)ois.readObject();
        Info.minei= (int)ois.readObject();
        Info.mineLeft= (int)ois.readObject();
        Info.round= (int)ois.readObject();
        Info.level= (int)ois.readObject();
        Info.roundNow= (int)ois.readObject();
        Info.playerNow= (int)ois.readObject();
        Info.roundLeftTime= (int)ois.readObject();
        MineMap.map= (int[][])ois.readObject();
        StatusMap.statusmap= (int[][])ois.readObject();
        Info.isHistory = true;

        new GameBoard();

    }

    public static void loadFromDirectoryFile(File file) throws Exception,IOException,ClassNotFoundException,FileNotFoundException,NullPointerException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        Info.playerScore = (int[])ois.readObject();
        Info.playerFaults = (int[])ois.readObject();
        Info.playerPoints= (int[])ois.readObject();
        Info.rowi= (int)ois.readObject();
        Info.coli= (int)ois.readObject();
        Info.minei= (int)ois.readObject();
        Info.mineLeft= (int)ois.readObject();
        Info.round= (int)ois.readObject();
        Info.level= (int)ois.readObject();
        Info.roundNow= (int)ois.readObject();
        Info.playerNow= (int)ois.readObject();
        Info.roundLeftTime= (int)ois.readObject();
        MineMap.map= (int[][])ois.readObject();
        StatusMap.statusmap= (int[][])ois.readObject();
        Info.isHistory = true;

        new GameBoard();
    }

    public static void loadReplay(int r) throws Exception,IOException,ClassNotFoundException,FileNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Replay\\"+r+".txt"));

        Info.playerScore = (int[])ois.readObject();
        Info.playerFaults = (int[])ois.readObject();
        Info.playerPoints= (int[])ois.readObject();
        Info.rowi= (int)ois.readObject();
        Info.coli= (int)ois.readObject();
        Info.minei= (int)ois.readObject();
        Info.mineLeft= (int)ois.readObject();
        Info.round= (int)ois.readObject();
        Info.level= (int)ois.readObject();
        Info.roundNow= (int)ois.readObject();
        Info.playerNow= (int)ois.readObject();
        Info.roundLeftTime= (int)ois.readObject();
        MineMap.map= (int[][])ois.readObject();
        StatusMap.statusmap= (int[][])ois.readObject();
        Info.isHistory = true;

//        g.refresh();
//        g.infoPanel.refresh(g);

    }
}
