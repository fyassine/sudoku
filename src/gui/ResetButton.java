package gui;

import javax.swing.*;
import java.awt.*;

public class ResetButton extends JButton {
    protected ResetButton(SudokuGrid currentGrid) {
        setText("Reset");
        setBackground(Color.white);
        setFont(new Font("Arial", Font.PLAIN, 17));
        setOpaque(true);

        addActionListener(evt -> {
            SudokuGrid resetGrid = new SudokuGrid();
            resetGrid.setDifficulty(currentGrid.getDifficulty());
            currentGrid.closeMainFrame();
            resetGrid.display();
        } );
    }
}
