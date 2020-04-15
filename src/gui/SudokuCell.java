package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuCell {
    private int row;
    private int col;
    private int value = 0;

    //todo change to protected after testing
    public SudokuCell(SudokuGrid currentGrid, JButton jButton, int row, int col) {
        this.row = row;
        this.col = col;

        jButton.setBackground(Color.white);
        jButton.setOpaque(true);
        jButton.setFont(new Font("Arial", Font.PLAIN, 20));

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(value == 0) currentGrid.setFilledFields(currentGrid.getFilledFields()+1);

                //clicked (number of clicks) must remain between 0 and 9
                value = (value % 9) + 1;
                ((JButton) e.getSource()).setText(Integer.toString(value));
            }
        });
    }

    public int getValue() {
        return value;
    }

    // TODO remove after testing
    public void setValue(int value) {
        this.value = value;
    }
}
