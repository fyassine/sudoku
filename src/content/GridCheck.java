package checker;

import gui.SudokuCell;
import gui.SudokuGrid;
import gui.SudokuSmallGrid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridCheck {
    /**
     * The grid on which the check is done
     */
    private final SudokuCell[][] cells;

    private final ArrayList<SudokuSmallGrid> smallerGrids;

    public GridCheck(SudokuGrid grid) {
        this.cells = grid.getCells();
        this.smallerGrids = grid.getSmallerGridsPanel().getSmallGrids();
    }

    /**
     * we check if in each row a number only appears once
     * @return if the rows are distinct or not
     */
    private boolean checkRows(){
        boolean result = true;
        int i = 0;
        while (i < 9 && result) {
            List<SudokuCell> row = Arrays.asList(cells[i]);
            result = row.stream().map(SudokuCell::getValue).distinct().count() == 9;
            i++;
        }
        return result;
    }

    /**
     * we check if in each column a number only appears once
     * @return if the columns are distinct or not
     */
    private boolean checkColumns(){
        boolean result = true;
        List<SudokuCell> column;
        for (int i = 0; i < 9; i++) {
            column = new ArrayList<>();
            int j = 0;
            while (j < 9 && result) {
                column.add(cells[j][i]);
            }
            result = column.stream().map(SudokuCell::getValue).distinct().count() == 9;
            j++;
        }
        return result;
    }

    /**
     * Check if 3x3 grids are all distinct
     * @return if the condition above is true
     */
    private boolean checkSmallerGrids(){
        boolean result = true;
        int i = 0;
        while(i < 9 && result) {
            SudokuSmallGrid smallGrid = smallerGrids.get(i);
            ArrayList<SudokuCell> cellsInSmallGrid = smallGrid.getCellsInSmallGrid();
            result = cellsInSmallGrid.stream().distinct().count() == 9;
            i++;
        }
        return result;
    }

    /**
     * a check by row, by column and by 3x3 grid
     * @return a boolean which tell if the player filled
     * the grid correctly or not
     */
    public boolean StartCheck() {
        return checkRows() && checkColumns() && checkSmallerGrids();
    }
}
