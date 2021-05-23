package cs102a.saver;

import cs102a.Info;
import cs102a.MineMap;
import cs102a.StatusMap;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;

public class GameSaver {


    public static void save() throws IOException, FileNotFoundException {
        int[] tempplayerScore = Info.playerScore;
        int[] tempplayerFaults = Info.playerFaults;
        int[] tempPoints = Info.playerPoints;
        int temptrowi = Info.rowi;
        int tempcoli = Info.coli;
        int tempminei = Info.minei;
        int tempMineLeft = Info.mineLeft;
        int tempround = Info.round;
        int level = Info.level;
        int temproundNow = Info.roundNow;
        int tempplayerNow = Info.playerNow;
        int temproundLeftTime = Info.roundLeftTime;
        int[][] tempmap = MineMap.map;
        int[][] tempstatusmap = StatusMap.statusmap;

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("History\\History.txt"));
        oos.writeObject(tempplayerScore);
        oos.writeObject(tempplayerFaults);
        oos.writeObject(tempPoints);
        oos.writeObject(temptrowi);
        oos.writeObject(tempcoli);
        oos.writeObject(tempminei);
        oos.writeObject(tempMineLeft);
        oos.writeObject(tempround);
        oos.writeObject(level);
        oos.writeObject(temproundNow);
        oos.writeObject(tempplayerNow);
        oos.writeObject(temproundLeftTime);
        oos.writeObject(tempmap);
        oos.writeObject(tempstatusmap);

        oos.close();
    }

    public static void saveWithName(String name) throws IOException {
        if (name.equals("")) {
            save();
            return;
        }
        int[] tempplayerScore = Info.playerScore;
        int[] tempplayerFaults = Info.playerFaults;
        int[] tempPoints = Info.playerPoints;
        int temptrowi = Info.rowi;
        int tempcoli = Info.coli;
        int tempminei = Info.minei;
        int tempMineLeft = Info.mineLeft;
        int tempround = Info.round;
        int level = Info.level;
        int temproundNow = Info.roundNow;
        int tempplayerNow = Info.playerNow;
        int temproundLeftTime = Info.roundLeftTime;
        int[][] tempmap = MineMap.map;
        int[][] tempstatusmap = StatusMap.statusmap;

        StringBuilder fileFullName = new StringBuilder();
        fileFullName.append("History\\");
        fileFullName.append(name);
        fileFullName.append(".txt");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileFullName.toString()));
        oos.writeObject(tempplayerScore);
        oos.writeObject(tempplayerFaults);
        oos.writeObject(tempPoints);
        oos.writeObject(temptrowi);
        oos.writeObject(tempcoli);
        oos.writeObject(tempminei);
        oos.writeObject(tempMineLeft);
        oos.writeObject(tempround);
        oos.writeObject(level);
        oos.writeObject(temproundNow);
        oos.writeObject(tempplayerNow);
        oos.writeObject(temproundLeftTime);
        oos.writeObject(tempmap);
        oos.writeObject(tempstatusmap);

        oos.close();
    }

    public static void replaySave() throws IOException, FileNotFoundException {
        int[] tempplayerScore = Info.playerScore;
        int[] tempplayerFaults = Info.playerFaults;
        int[] tempPoints = Info.playerPoints;
        int temptrowi = Info.rowi;
        int tempcoli = Info.coli;
        int tempminei = Info.minei;
        int tempMineLeft = Info.mineLeft;
        int tempround = Info.round;
        int level = Info.level;
        int temproundNow = Info.roundNow;
        int tempplayerNow = Info.playerNow;
        int temproundLeftTime = Info.roundLeftTime;
        int[][] tempmap = MineMap.map;
        int[][] tempstatusmap = StatusMap.statusmap;

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Replay\\"+temproundNow+".txt"));
        oos.writeObject(tempplayerScore);
        oos.writeObject(tempplayerFaults);
        oos.writeObject(tempPoints);
        oos.writeObject(temptrowi);
        oos.writeObject(tempcoli);
        oos.writeObject(tempminei);
        oos.writeObject(tempMineLeft);
        oos.writeObject(tempround);
        oos.writeObject(level);
        oos.writeObject(temproundNow);
        oos.writeObject(tempplayerNow);
        oos.writeObject(temproundLeftTime);
        oos.writeObject(tempmap);
        oos.writeObject(tempstatusmap);

        oos.close();
    }

}

