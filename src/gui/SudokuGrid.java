package gui;

import javax.swing.*;
import java.awt.*;

public class SudokuGrid {
	private int filledFields;
	SudokuCell[][] cells = new SudokuCell[9][9];
	private JFrame mainFrame;
	private JPanel panelForSolvingButton;
	private JPanel smallerGridPanel;

	//todo change to protected after testing
	public SudokuGrid() {
		mainFrame = new JFrame("sudoku-solver");
	}

	public void display() {
		SwingUtilities.invokeLater(this::createAndShowGUI);
	}

	void createAndShowGUI() {
		JOptionPane.showMessageDialog(new JPanel(), "Please fill in the grid by clicking on the desired cell");

		mainFrame.setLayout(new BorderLayout());

		smallerGridPanel = new JPanel(new GridLayout(3, 3));
		mainFrame.add(smallerGridPanel, BorderLayout.CENTER);

		panelForSolvingButton = new JPanel();
		panelForSolvingButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		mainFrame.add(panelForSolvingButton, BorderLayout.SOUTH);

		mainFrame.pack();
		mainFrame.setSize(600,600);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);


		panelForSolvingButton.add(new SolveButton(this));
		addRegularButtons();
	}

	void addRegularButtons() {
		int currentCol = 0;
		int currentRow = 0;
		int smallerGridFirstCol = 0;
		int firstRowOfLayer = 0;

		for (int layerOfGrids = 0; layerOfGrids < 3; ++layerOfGrids) {
			for (int gridOfLayer = 0; gridOfLayer < 3; ++gridOfLayer) {
				JComponent smallerGrid = new JPanel(new GridLayout(3, 3));
				smallerGrid.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
				smallerGridPanel.add(smallerGrid);

				for (int j = 0; j < 3; ++j) {
					for (int k = 0; k < 3; ++k) {
						var cell = new JButton();
						SudokuCell sudokuCell = new SudokuCell(this, cell, currentRow, currentCol);
						cells[currentRow][currentCol] = sudokuCell;
						smallerGrid.add(cell);
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
		mainFrame.setVisible(true);
	}

	public int getFilledFields() {
		return filledFields;
	}

	public void setFilledFields(int filledFields) {
		this.filledFields = filledFields;
	}
}
