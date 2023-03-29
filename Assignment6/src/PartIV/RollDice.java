package PartIV;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class RollDice extends JFrame {
    String result;
    JTextArea resultField;
    JMenuBar menuBar;
    JButton rollDice;
    JMenu file;
    JPanel northPanel;
    JPanel middlePanel;
    JPanel southPanel;
    JMenuItem item;
    boolean isFinished = false;
    int score = 0;
    int lastIndex = 0;
    ArrayList<JLabel> list = new ArrayList<JLabel>();

    public RollDice() {
        super("Roll Dice");
        northPanel = new JPanel();
        middlePanel = new JPanel();
        southPanel = new JPanel();
        resultField = new JTextArea();
        resultField.setEditable(false);
        resultField.setFont(new Font("SansSerif", Font.BOLD, 16));
        resultField.setBackground(Color.WHITE);
        resultField.setMaximumSize(new Dimension(80, 20));
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        file = new JMenu("File");
        item = new JMenuItem("Exit");
        item.addActionListener((e) -> System.exit(0));
        rollDice = new JButton("Roll Dice");
        rollDice.addActionListener((e) -> roll());


        file.add(item);
        menuBar.add(file);

        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
        northPanel.add(new ImagePanel("./die1.png"));
        northPanel.add(new ImagePanel("./die1.png"));

        middlePanel.setLayout(new GridLayout(5, 5));
        middlePanel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        for (int i =0; i<(5*5); i++){
            JLabel label = new JLabel();
            label.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            label.setFont(new Font("Face", Font.PLAIN, 60));
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            middlePanel.add(label);
            list.add(label);
        }
        list.get(lastIndex).setText("x");

        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        resultField.setAlignmentX(Component.CENTER_ALIGNMENT);
        rollDice.setAlignmentX(Component.CENTER_ALIGNMENT);
        southPanel.add(Box.createVerticalStrut(20));
        southPanel.add(resultField);
        southPanel.add(Box.createVerticalStrut(20));
        southPanel.add(rollDice);
        resultField.setText("Result: ");

        this.add(northPanel, BorderLayout.NORTH);
        this.add(middlePanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);


        this.setSize(800, 1100);
    }


    private void roll() {
        if (isFinished) return;
        int die1 = (int) (Math.random() * 6) + 1;
        int die2 = (int) (Math.random() * 6) + 1;
        result =  Integer.toString(die1 + die2);
        resultField.setText("Result: " + result);

        northPanel.removeAll();
        northPanel.add(new ImagePanel("./die" + die1 + ".png"));
        northPanel.add(new ImagePanel("./die" + die2 + ".png"));

        if (lastIndex + die1 + die2 >= 24) {
            isFinished = true;
            list.get(lastIndex).setText("");
            lastIndex = 24;
            list.get(lastIndex).setText("x");
            middlePanel.removeAll();
            middlePanel.setLayout(new GridLayout(1, 1));
            JLabel label = new JLabel("Finished!", JLabel.CENTER);
            label.setFont(new Font("Face", Font.PLAIN, 60));
            middlePanel.add(label);
        }else {
            list.get(lastIndex).setText("");
            lastIndex += die1 + die2;
            list.get(lastIndex).setText("x");
        }
    }

    public static void main(String[] args) {
        RollDice frame = new RollDice();
        frame.setTitle("Roll Dice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}

