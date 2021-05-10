package cs102a.saver;

import cs102a.MineMap;
import cs102a.gui.model.TimeDialog;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class GameSaver {
    /**
     * @param map  the current mine map, s
     * @param path
     */
    public static void save(MineMap map, JFrame currentWindow, String path) {
        BufferedWriter bufferedWriter = null;
        String savedInfo = "";// TODO: 2021/4/25

        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path, true)));      // FileOutputStream 第二个参数：追加写入/覆写
            bufferedWriter.write(savedInfo);
            bufferedWriter.write(savedInfo);
            bufferedWriter.flush();
        } catch (Exception e) {
            new TimeDialog(currentWindow, "Fail to save game.", 5);
        } finally {
            try {
                assert bufferedWriter != null;
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
