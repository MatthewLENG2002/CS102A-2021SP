package cs102a.gui.model;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeDialog extends JDialog {
    private int seconds;

    /**
     * @param jFrameOfBtn 程序主窗口（按钮所在）
     * @param msg         对话框主体消息
     * @param closeInSec  以秒记的自动关闭时间，可以提前按按钮关闭
     */
    public TimeDialog(JFrame jFrameOfBtn, String msg, int closeInSec) {
        super(jFrameOfBtn, true);
        this.setLayout(null);

        seconds = closeInSec;
        JLabel label = new JLabel(msg, JLabel.CENTER);
        label.setBounds(80, 10, 200, 20);

        ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();

        JButton confirm = new JButton("Ok");
        confirm.setBounds(140, 120, 50, 60);
        confirm.addActionListener(e -> this.dispose());

        this.setTitle("This turn will be skipped in " + seconds + " sec");
        this.setLayout(new GridLayout(2, 1));
        this.add(label);
        this.add(confirm);

        s.scheduleAtFixedRate(() -> {
            TimeDialog.this.seconds--;
            if (TimeDialog.this.seconds == 0) {
                this.dispose();
                System.gc();
            } else {
                this.setTitle("This turn will be skipped in " + seconds + " sec");
            }
        }, 1, 1, TimeUnit.SECONDS);

        this.setSize(new Dimension(250, 100));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
