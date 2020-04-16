package gui;

public class SudokuGameStarter {
    private final SudokuGrid sudokuGrid;

    private SudokuGameStarter() {
        this.sudokuGrid = new SudokuGrid();
    }

    private void start() {
        new StartOptionPanel(sudokuGrid);
    }

    public static void main(String[] args) {
        new SudokuGameStarter().start();
    }

}
