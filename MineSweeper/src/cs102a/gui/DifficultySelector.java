package cs102a.gui;

import cs102a.Info;
import cs102a.gui.model.TimeDialog;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DifficultySelector extends JFrame {
//    int level;

    public DifficultySelector() {
        JButton start;
        JRadioButton beginner, intermediate, advanced, custom;
        JTextField width = null, length = null, mines = null;

        JLabel title = new JLabel("Difficulty", JLabel.CENTER);
        title.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 50));
        title.setForeground(Color.BLACK);
        title.setOpaque(false);
        add(title);

        beginner = new JRadioButton("Beginner");
        beginner.setBounds(40, 40, 150, 20);
        add(beginner);
        beginner.addActionListener(e -> {
            Info.level = 1;
            Info.rowi = 9;
            Info.coli = 9;
            Info.minei = 10;
        });

        JLabel bDescFirstLine = new JLabel("10 mines");
        bDescFirstLine.setBounds(70, 60, 100, 20);
        JLabel bDescSecondLine = new JLabel("9 x 9 grid");
        bDescSecondLine.setBounds(70, 80, 100, 20);
        add(bDescFirstLine);
        add(bDescSecondLine);

        intermediate = new JRadioButton("Intermediate");
        intermediate.setBounds(40, 100, 150, 20);
        add(intermediate);
        intermediate.addActionListener(e -> {
            Info.level = 2;
            Info.rowi = 16;
            Info.coli = 16;
            Info.minei = 40;
        });

        JLabel iDescFirstLine = new JLabel("40 mines");
        iDescFirstLine.setBounds(70, 120, 100, 20);
        JLabel iDescSecondLine = new JLabel("16 x 16 grid");
        iDescSecondLine.setBounds(70, 140, 100, 20);
        add(iDescFirstLine);
        add(iDescSecondLine);

        advanced = new JRadioButton("Advanced");
        advanced.setBounds(40, 160, 160, 20);
        add(advanced);
        advanced.addActionListener(e -> {
            Info.level = 3;
            Info.rowi = 16;
            Info.coli = 30;
            Info.minei = 99;
        });

        JLabel aDescFirstLine = new JLabel("99 mines");
        aDescFirstLine.setBounds(70, 180, 100, 20);
        JLabel aDescSecondLine = new JLabel("16 x 30 grid");
        aDescSecondLine.setBounds(70, 200, 100, 20);
        add(aDescFirstLine);
        add(aDescSecondLine);

        custom = new JRadioButton("Custom");
        custom.setBounds(40, 220, 100, 20);
        add(custom);
        custom.addActionListener(e -> {
            Info.level = 4;
        });

        JLabel widthLabel = new JLabel("Width <= 24:");
        widthLabel.setBounds(70, 240, 80, 20);
        add(widthLabel);

        width = new JTextField();
        width.setBounds(170, 240, 40, 20);
        add(width);

        JLabel lengthLabel = new JLabel("Length <= 30:");
        lengthLabel.setBounds(70, 260, 90, 20);
        add(lengthLabel);

        length = new JTextField();
        length.setBounds(170, 260, 40, 20);
        add(length);

        JLabel mineLabel = new JLabel("Mines <= width*length:");
        mineLabel.setBounds(10, 280, 150, 20);
        add(mineLabel);

        mines = new JTextField();
        mines.setBounds(170, 280, 40, 20);
        add(mines);

        start = new JButton("Start");
        start.setBounds(80, 320, 100, 20);
        add(start);
        JTextField finalWidth = width;
        JTextField finalLength = length;
        JTextField finalMines = mines;
        start.addActionListener(e -> {
            if (Info.level == 4) {
                int row =0, col=0, mine =0;
                boolean isValid = true;
                try {
                    row = Integer.parseInt(finalWidth.getText());
                    col = Integer.parseInt(finalLength.getText());
                    mine = Integer.parseInt(finalMines.getText());
                    if (!(row <= 24 && row >= 0) || !(col >= 0 && col <= 30) || !(mine >= 0 && mine <= row * col / 2))
                        throw new IllegalArgumentException("OutOfBounds!");

                } catch (NumberFormatException ne) {
                    new TimeDialog(this, "Please enter the right figure!", 3);
                    isValid = false;
                } catch (IllegalArgumentException iae) {
                    new TimeDialog(this, iae.getMessage(), 3);
                    isValid = false;
                }
                if (!isValid) {
                    this.dispose();
                    new DifficultySelector();
                } else {
                    Info.rowi = row;
                    Info.coli = col;
                    Info.minei = mine;
                    this.dispose();
                    new RoundChooser();
                }
            } else if (!beginner.isSelected() && !intermediate.isSelected() && !advanced.isSelected() && !custom.isSelected()) {
                new TimeDialog(this, "Please select level!", 3);
            } else {
                this.dispose();
                new RoundChooser();
            }

        });

        width.setEditable(true);
        length.setEditable(true);
        mines.setEditable(true);

        ButtonGroup group = new ButtonGroup();
        group.add(beginner);
        group.add(intermediate);
        group.add(advanced);
        group.add(custom);


        setSize(280, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }


}

