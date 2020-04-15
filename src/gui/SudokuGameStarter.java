package gui;

public class SudokuGameStarter {
    private final SudokuGrid sudokuGrid;

    private SudokuGameStarter() {
        this.sudokuGrid = new SudokuGrid();
    }

    private void start() {
        sudokuGrid.display();
    }

    public static void main(String[] args) {
        new SudokuGameStarter().start();
    }

}
