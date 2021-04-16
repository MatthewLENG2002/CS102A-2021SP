package ref.cs102a.aeroplane.frontend;

import ref.cs102a.aeroplane.GameInfo;
import ref.cs102a.aeroplane.frontend.model.BackgroundPanel;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Start {
    private static final JFrame startFrame = new JFrame("飞行棋");

    public static void main(String[] args) {
        JLabel title = new JLabel("飞行棋", JLabel.CENTER);
        title.setFont(new java.awt.Font("微软雅黑", Font.BOLD, 50));
        title.setForeground(Color.BLACK);
        title.setOpaque(false);

        JButton startButton = new JButton("开始游戏");
        startButton.setOpaque(false);
        startButton.setBorder(null);
        startButton.setForeground(Color.YELLOW);
        startButton.setFont(new java.awt.Font("微软雅黑", Font.BOLD, 26));
        startButton.addActionListener(e -> {
            GameGUI game = new GameGUI();
            game.setVisible(true);
            game.getChessBoard().startGame();
        });


        String picPath = SystemSelect.getImagePath();
        JPanel startPanel = new BackgroundPanel((new ImageIcon(picPath + "start.jpg").getImage()));
        startPanel.add(subStartPanel);
        startFrame.add(startPanel);
        startFrame.setSize(400, 600);

        startFrame.setLocationRelativeTo(null);
        startFrame.setResizable(false);
        startFrame.setVisible(true);
        startFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
