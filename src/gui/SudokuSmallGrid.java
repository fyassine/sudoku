package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SudokuSmallGrid extends JPanel {
    private ArrayList<SudokuCell> cellsInSmallGrid = new ArrayList<>();

    /**
     * a standard JPanel constructor
     * @param layout is the layout set for the panel
     * here a gridLayout
     */
    public SudokuSmallGrid(LayoutManager layout) {
        super(layout);
    }

    /**
     * saves the button of each cell into the 3x3 grid
     * @param cell is the cell that is being processed
     */
    protected void addAndSaveCell(SudokuCell cell) {
        add(cell.getCellButton());
        cellsInSmallGrid.add(cell);
    }

    public ArrayList<SudokuCell> getCellsInSmallGrid() {
        return cellsInSmallGrid;
    }
}
