package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuCell {
    private int row;
    private int col;
    private int value = 0;
    private JButton cellButton = new JButton();

    protected SudokuCell(SudokuGrid currentGrid, int row, int col) {
        this.row = row;
        this.col = col;

        cellButton.setBackground(Color.white);
        cellButton.setOpaque(true);
        cellButton.setFont(new Font("Arial", Font.PLAIN, 20));

        cellButton.addActionListener(e -> {
            if(value == 0) {
                currentGrid.setFilledFields(currentGrid.getFilledFields()+1);
            }

            //clicked (number of clicks) must remain between 0 and 9
            if(!currentGrid.getStartingCells().contains(this))value = (value % 9) + 1;
            ((JButton) e.getSource()).setText(Integer.toString(value));
        });
    }

    public int getValue() {
        return value;
    }

    public JButton getCellButton() {
        return cellButton;
    }

    public void setValue(int value) {
        this.value = value;
        cellButton.setText(String.valueOf(value));
    }
}
