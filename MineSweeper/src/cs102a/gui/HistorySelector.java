package cs102a.gui;

import cs102a.gui.model.SmallGrid;
import cs102a.saver.HistoryLoader;

import javax.swing.*;
import java.awt.*;

public class HistorySelector extends JFrame {

    public HistorySelector() {
        super("Mine Sweeper");

        JLabel title = new JLabel("HistorySelector", JLabel.CENTER);
        title.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 50));
        title.setForeground(Color.BLACK);
        title.setOpaque(false);

        JButton slot1 = new JButton("Load History");
        slot1.setOpaque(false);
        slot1.setBorder(null);
        slot1.setForeground(Color.BLACK);
        slot1.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        slot1.addActionListener(e -> {
            try {
                new HistoryLoader().load();
                this.dispose();
            } catch (Exception exception) {
                exception.printStackTrace();
                JDialog loadFailure = new JDialog();
                loadFailure.setVisible(true);
                loadFailure.setDefaultCloseOperation(HIDE_ON_CLOSE);
                loadFailure.setSize(120, 100);
                loadFailure.setLocationRelativeTo(null);
                JLabel failed = new JLabel("Load Failed!",JLabel.CENTER);
                loadFailure.add(failed);
            }

        });

        JButton LoadFile = new JButton("Load File");
        LoadFile.setOpaque(false);
        LoadFile.setBorder(null);
        LoadFile.setForeground(Color.BLACK);
        LoadFile.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        LoadFile.addActionListener(e -> {
            JFileChooser loadFile = new JFileChooser("History");
            loadFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
            loadFile.showOpenDialog(null);
            loadFile.setMultiSelectionEnabled(false);
                try {
                    new HistoryLoader().loadFromDirectoryFile(loadFile.getSelectedFile());
                    this.dispose();
                } catch (Exception exception) {
                    exception.printStackTrace();
                    JDialog loadFailure = new JDialog();
                    loadFailure.setVisible(true);
                    loadFailure.setDefaultCloseOperation(HIDE_ON_CLOSE);
                    loadFailure.setSize(120, 100);
                    loadFailure.setLocationRelativeTo(null);
                    JLabel failed = new JLabel("Load Failed!",JLabel.CENTER);
                    loadFailure.add(failed);
                }

        });


        JButton home = new JButton("Home");
        home.setOpaque(false);
        home.setBorder(null);
        home.setForeground(Color.BLACK);
        home.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 26));
        home.addActionListener(e -> {
            this.setVisible(false);
            StartMenu.start.setVisible(true);
        });

        setLayout(new GridLayout(3, 1, 2, 2));
        add(new SmallGrid(3, 3, slot1));
        add(new SmallGrid(3, 3, LoadFile));
        add(new SmallGrid(3, 3, home));

        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}
