package cs102a.gui;

import cs102a.Info;
import cs102a.MineMap;
import cs102a.StatusMap;
import cs102a.gui.model.SmallGrid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameSquare extends JButton {
    int xLocation;
    int yLocation;

    public GameSquare(int x, int y){
        xLocation = x;
        yLocation = y;
        this.setIcon(SquareImage(xLocation,yLocation, StatusMap.statusmap, MineMap.map));
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1){
                    StatusMap.uncover(xLocation,yLocation);
                    GameSquare.this.setIcon(SquareImage(xLocation,yLocation,StatusMap.statusmap, MineMap.map));
                }
                if (e.getButton() == MouseEvent.BUTTON3){
                    if (!StatusMap.flag(xLocation,yLocation)){
                        JDialog wrongFlag = new JDialog();
                        wrongFlag.setVisible(true);
                        wrongFlag.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                        wrongFlag.setLocationRelativeTo(null);
                        wrongFlag.setSize(200, 150);
                        wrongFlag.setLayout(new GridLayout(2, 1));

                        JLabel title = new JLabel("Wrong Flag!", JLabel.CENTER);
                        title.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 20));
                        title.setForeground(Color.BLACK);
                        title.setOpaque(false);
                        wrongFlag.add(title);

                        JButton confirm = new JButton("Confirm");
                        confirm.setOpaque(false);
                        confirm.setBorder(null);
                        confirm.setForeground(Color.BLACK);
                        confirm.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 15));
                        wrongFlag.add(new SmallGrid(3, 3, confirm));
                        confirm.addActionListener(e1 -> {
                            wrongFlag.dispose();
                        });
                    }
                    GameSquare.this.setIcon(SquareImage(xLocation,yLocation,StatusMap.statusmap, MineMap.map));
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }

    public GameSquare(int x, int y, boolean cheat){
        if (cheat){
            xLocation = x;
            yLocation = y;
            int[][] cheatstatusmap = new int[Info.rowi][Info.coli];
            for (int i = 0; i < cheatstatusmap.length; i++) {
                for (int j = 0; j < cheatstatusmap[0].length; j++) {
                    cheatstatusmap[i][j] = 1;
                }
            }
            this.setIcon(SquareImage(xLocation,yLocation,cheatstatusmap, MineMap.map));
        }

    }

    public ImageIcon SquareImage(int x, int y, int[][] statuesmap, int[][] map){
        if (statuesmap[x-1][y-1] == 0){
            ImageIcon img = new ImageIcon("images/block.png");
            return img;
        }
        else if (statuesmap[x-1][y-1] == -1){
            ImageIcon img = new ImageIcon("images/redFlag.png");
            return img;
        }
        else if (statuesmap[x-1][y-1] == -2){
            ImageIcon img = new ImageIcon("images/flagWrong.png");
            return img;
        }
        else if (statuesmap[x-1][y-1] == 1){
            switch(map[x-1][y-1]){
                case 0 -> {ImageIcon img = new ImageIcon("images/0.png"); return img;}
                case 1 -> {ImageIcon img = new ImageIcon("images/1.png"); return img;}
                case 2 -> {ImageIcon img = new ImageIcon("images/2.png"); return img;}
                case 3 -> {ImageIcon img = new ImageIcon("images/3.png"); return img;}
                case 4 -> {ImageIcon img = new ImageIcon("images/4.png"); return img;}
                case 5 -> {ImageIcon img = new ImageIcon("images/5.png"); return img;}
                case 6 -> {ImageIcon img = new ImageIcon("images/6.png"); return img;}
                case 7 -> {ImageIcon img = new ImageIcon("images/7.png"); return img;}
                case 8 -> {ImageIcon img = new ImageIcon("images/8.png"); return img;}
                case -1,-2,-3,-4,-5,-6,-7,-8 -> {ImageIcon img = new ImageIcon("images/bomb.png"); return img;}
            }
        }
        return null;
    }

}

