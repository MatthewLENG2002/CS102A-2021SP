package cs102a.util;

import java.awt.*;

public class Timer {

    public static void delay(int ms) {
        try {
            Robot robot = new Robot();
            robot.delay(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
