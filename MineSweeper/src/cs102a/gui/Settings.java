package cs102a.gui;

import cs102a.Info;
import cs102a.gui.model.BackgroundPanel;
import cs102a.gui.model.SmallGrid;

import javax.swing.*;
import java.awt.*;

public class Settings extends JFrame {

    public static Settings settings = new Settings();
    public BackgroundPanel bg = new BackgroundPanel();

    public Settings() {
        super("Mine Sweeper");

        JLabel title = new JLabel("Settings", JLabel.CENTER);
        title.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 50));
        title.setForeground(Color.BLACK);
        title.setOpaque(false);

        JLabel theme = new JLabel("Theme: ");
        theme.setOpaque(false);
        theme.setBorder(null);
        theme.setForeground(Color.BLACK);
        theme.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
//        theme.addActionListener(e -> {
//
//        });

        JRadioButton th1 = new JRadioButton("Dawn");
        th1.setOpaque(false);
        th1.addActionListener(e -> {
            if (th1.isSelected()) Info.theme = 1;
            BackgroundPanel.updateAll();
            settings.setVisible(false);
            StartMenu.start.setVisible(true);
        });

        JRadioButton th2 = new JRadioButton("Dusk");
        th2.setOpaque(false);
        th2.addActionListener(e -> {
            if (th2.isSelected()) Info.theme = 2;
            BackgroundPanel.updateAll();
            settings.setVisible(false);
            StartMenu.start.setVisible(true);
        });

        JRadioButton th3 = new JRadioButton("Night");
        th3.setOpaque(false);
        th3.addActionListener(e -> {
            if (th3.isSelected()) Info.theme = 3;
            BackgroundPanel.updateAll();
            settings.setVisible(false);
            StartMenu.start.setVisible(true);
        });

        JRadioButton th4 = new JRadioButton("Rainbow");
        th4.setOpaque(false);
        th4.addActionListener(e -> {
            if (th4.isSelected()) Info.theme = 4;
            BackgroundPanel.updateAll();
            settings.setVisible(false);
            StartMenu.start.setVisible(true);
        });

        ButtonGroup themeSelector = new ButtonGroup();
        themeSelector.add(th1);
        themeSelector.add(th2);
        themeSelector.add(th3);
        themeSelector.add(th4);

        switch (Info.theme) {
            case 1 -> th1.setSelected(true);
            case 2 -> th2.setSelected(true);
            case 3 -> th3.setSelected(true);
            case 4 -> th4.setSelected(true);
        }

        JPanel themePanel = new JPanel();
        themePanel.setLayout(new GridLayout(1, 4));
        themePanel.add(theme);
        themePanel.add(th1);
        themePanel.add(th2);
        themePanel.add(th3);
        themePanel.add(th4);
        themePanel.setOpaque(false);


        JButton rank = new JButton("Rank");
        rank.setOpaque(false);
        rank.setBorder(null);
        rank.setForeground(Color.BLACK);
        rank.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        rank.addActionListener(e -> {
            JDialog ranking = new JDialog();
            ranking.setVisible(true);
            ranking.setLocationRelativeTo(null);
            ranking.setSize(200, 300);
            ranking.setLayout(new GridLayout(2,1));

            JLabel rankTitle = new JLabel("Rank",JLabel.CENTER);
            rankTitle.setOpaque(true);
            ranking.add(rankTitle);

            String[] items;
            if (Info.playerPoints[0] >= Info.playerPoints[1]){
                items = new String[]{"Player 1 | "+Info.playerPoints[0]+"       ","Player 2 | "+Info.playerPoints[1]+"       "};
            }
            else items = new String[]{"Player 2 | "+Info.playerPoints[1]+"       ","Player 1 | "+Info.playerPoints[0]+"       "};
            JList list = new JList(items);
            list.setOpaque(true);
            DefaultListCellRenderer render = new DefaultListCellRenderer();
            render.setHorizontalAlignment(SwingConstants.CENTER);
            list.setCellRenderer(render);
            ranking.add(list);


        });

//        JButton cheat = new JButton("Cheat");
//        cheat.setOpaque(false);
//        cheat.setBorder(null);
//        cheat.setForeground(Color.BLACK);
//        cheat.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
//        cheat.addActionListener(e -> {
//
//        });

        JButton home = new JButton("Home");
        home.setOpaque(false);
        home.setBorder(null);
        home.setForeground(Color.BLACK);
        home.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        home.addActionListener(e -> {
            settings.setVisible(false);
            StartMenu.start.setVisible(true);
        });

        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Info.bgPanel.add(bg);
        bg.setLayout(new GridLayout(4, 1, 2, 2));
        bg.add(title);
        bg.add(themePanel);
        bg.add(new SmallGrid(3, 3, rank));
//        add(new SmallGrid(3, 3, cheat));
        bg.add(new SmallGrid(3, 3, home));
        this.add(bg);

    }
}



