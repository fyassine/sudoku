package gui;

import content.GridCheck;

import javax.swing.*;
import java.awt.*;

public class DoneButton extends JButton{

    protected DoneButton(SudokuGrid currentGrid) {
        setText("Done ?");
        setBackground(Color.white);
        setFont(new Font("Arial", Font.PLAIN, 17));
        setOpaque(true);


        addActionListener(evt -> {
            if(currentGrid.getFilledFields() < 81)
                JOptionPane.showMessageDialog(new JPanel(), "You need to fill in all the cells first!");
            else {
                if(new GridCheck(currentGrid).StartCheck()) {
                    JOptionPane.showMessageDialog(new JPanel(), "well done!");
                } else {
                    JOptionPane.showMessageDialog(new JPanel(), "wrong Input! Please try again.");
                }
            }
        });
    }
}
