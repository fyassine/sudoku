package gui;

import content.GridGenerator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SudokuGrid {
	private int filledFields;
	SudokuCell[][] cells = new SudokuCell[9][9];
	private JFrame mainFrame;
	private JPanel panelForOptionButtons;
	private PanelForSudokuSmallGrids smallerGridsPanel;
	private String difficulty;
	private ArrayList<SudokuCell> startingCells = new ArrayList<>();

	SudokuGrid() {
		mainFrame = new JFrame("sudoku-solver");
	}

	public void display() {
		SwingUtilities.invokeLater(this::createAndShowGUI);
	}

	void createAndShowGUI() {
		mainFrame.setLayout(new BorderLayout());

		smallerGridsPanel = new PanelForSudokuSmallGrids(new GridLayout(3, 3));
		mainFrame.add(smallerGridsPanel, BorderLayout.CENTER);

		panelForOptionButtons = new JPanel();
		panelForOptionButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		mainFrame.add(panelForOptionButtons, BorderLayout.SOUTH);

		mainFrame.pack();
		mainFrame.setSize(600,600);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);

		panelForOptionButtons.add(new ResetButton(this));
		panelForOptionButtons.add(new DoneButton(this));
		addRegularButtons();
	}

	void addRegularButtons() {
		int currentCol = 0;
		int currentRow = 0;
		int smallerGridFirstCol = 0;
		int firstRowOfLayer = 0;

		for (int layerOfGrids = 0; layerOfGrids < 3; ++layerOfGrids) {
			for (int gridOfLayer = 0; gridOfLayer < 3; ++gridOfLayer) {
				SudokuSmallGrid smallerGrid = new SudokuSmallGrid(new GridLayout(3, 3));
				smallerGrid.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
				smallerGridsPanel.add(smallerGrid);

				for (int j = 0; j < 3; ++j) {
					for (int k = 0; k < 3; ++k) {
						SudokuCell sudokuCell = new SudokuCell(this, currentRow, currentCol);
						cells[currentRow][currentCol] = sudokuCell;
						smallerGrid.addAndSaveCell(sudokuCell);
						currentCol++;
					}
					currentRow++;
					currentCol = smallerGridFirstCol;
				}

				currentRow = firstRowOfLayer;
				smallerGridFirstCol += 3;
				currentCol = smallerGridFirstCol;
			}

			firstRowOfLayer += 3;
			currentRow = firstRowOfLayer;
			smallerGridFirstCol = currentCol = 0;
		}
		generate();
		mainFrame.setVisible(true);
	}

	private void generate(){
		int[][] gridTemplate = new GridGenerator(difficulty).generate();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int value = gridTemplate[i][j];
				if(value != 0) {
					SudokuCell cell = cells[i][j];
					cell.setValue(value);
					startingCells.add(cell);
					filledFields++;
				}
			}
		}
	}

	protected void closeMainFrame(){
		mainFrame.dispose();
	}

	public String getDifficulty() { return difficulty; }

	public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

	public int getFilledFields() {
		return filledFields;
	}

	public void setFilledFields(int filledFields) {
		this.filledFields = filledFields;
	}

	public SudokuCell[][] getCells() {
		return cells;
	}

	public PanelForSudokuSmallGrids getSmallerGridsPanel() {
		return smallerGridsPanel;
	}

	public ArrayList<SudokuCell> getStartingCells() {
		return startingCells;
	}
}
