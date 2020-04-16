package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StartOptionPanel extends JFrame {
    private SudokuGrid grid;

    private void showHintWhenClicked(JButton button) {
        button.addActionListener(e -> {
            dispose();
            grid.setDifficulty(button.getText());
            grid.display();
        });
    }

    protected StartOptionPanel(SudokuGrid grid) {
        this.grid = grid;

        setResizable(false);
        setLayout(new GridLayout(3, 1));
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame frameForText = new JFrame();
        JPanel panelForText = new JPanel();
        JLabel text = new JLabel("Please choose the difficulty: ");
        panelForText.add(text);
        frameForText.add(panelForText);
        frameForText.setLocationRelativeTo(null);

        JFrame frameForNote = new JFrame();
        JPanel panelForNote = new JPanel();
        JLabel note = new JLabel("(note :fill in the grid by clicking on the cell)");
        panelForNote.add(note);
        frameForNote.add(panelForNote);
        frameForNote.setLocationRelativeTo(null);

        JPanel difficultyButtonsPanel = new JPanel(new GridLayout(1, 3));
        ArrayList<JButton> jButtons = new ArrayList<>();
        jButtons.add(new JButton("easy"));
        jButtons.add(new JButton("medium"));
        jButtons.add(new JButton("difficult"));

        for (JButton button : jButtons) {
            showHintWhenClicked(button);
            difficultyButtonsPanel.add(button);
        }


        // add and show the content of the frame
        add(panelForText);
        add(panelForNote);
        add(difficultyButtonsPanel);
        setVisible(true);
    }
}
