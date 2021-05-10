package cs102a.saver;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HistoryLoader {

    /**
     * @throws SecurityException     演示时手动准备错误的文件头
     * @throws Exception             演示时手动准备错误的文件头
     * @throws NumberFormatException 读档异常，数据切分错误
     * @description: 在询问用户选择存档名后读取存档，并清除原来path
     */
    public static void tryToLoad() throws Exception {
        try {
            Scanner sc = new Scanner(new File(filePath));
//            assert sc.hasNext():"fail";

            // 检查文件是否存在异常
            // 读档
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SecurityException se) {
        }
    }
}