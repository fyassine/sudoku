package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelForSudokuSmallGrids extends JPanel {
    private ArrayList<SudokuSmallGrid> smallGrids = new ArrayList<>();

    public PanelForSudokuSmallGrids(LayoutManager layout) {
        super(layout);
    }

    /**
     * saves the smaller grids
     * @param smallGrid is a 3x3 grid
     */
    protected void addAndSaveSmallGrid(SudokuSmallGrid smallGrid) {
        add(smallGrid);
        smallGrids.add(smallGrid);
    }

    public ArrayList<SudokuSmallGrid> getSmallGrids() {
        return smallGrids;
    }
}
