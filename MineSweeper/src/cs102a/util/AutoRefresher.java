import java.awt.*;

//public class RefreshBot {
//    public static void delay(int ms) {
//        try {
//            Robot robot = new Robot();
//            robot.delay(ms);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

public class AutoRefresher extends Thread {
    @Override
    public void run() {
        while (true) {
            if (Info.roundLeftTime == 0) {
                Info.roundLeftTime = 5;
                Info.round++;
                continue;
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Info.roundLeftTime--;
        }
    }
}