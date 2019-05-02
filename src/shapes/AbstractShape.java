package shapes;

import api.Block;
import api.Cell;
import api.Position;
import api.Shape;

/**
 * Abstract superclass for implementations of the Shape interface.
 * 
 * @author SMSheets@IAState.edu - Steven Marshall Sheets
 */
public abstract class AbstractShape implements Shape
{
	/**
	 * Holds the position of the cell. More importantly, the center of rotation of
	 * the cell, for their transformation.
	 */
	private Position position;

	/**
	 * The cell array. When properly filled, this will create a shape.
	 */
	private Cell[] cells;

	/**
	 * Constructor that creates an abstract shape.
	 * 
	 * @param givenPosition The center of rotation for the shape.
	 */
	protected AbstractShape(Position givenPosition)
	{
		position = givenPosition;
	}

	/**
	 * Adds the cells (from classes that extend AbstractShape) to this method's
	 * instance of cells.
	 * 
	 * @param cellArr The cell array that will be used to replace our current
	 *                instance of cells.
	 */
	protected void addCells(Cell[] cellArr)
	{
		cells = cellArr;
	}

	/**
	 * Cycles the blocks within the cells of this shape. Starts at cells[0] up to
	 * cells[length - 1], then back to the first cell.
	 */
	public void cycle()
	{
		Block tempBlock = cells[0].getBlock();

		cells[0].setBlock(cells[cells.length - 1].getBlock());

		for (int i = cells.length - 1; i > 1; i--)
		{
			cells[i].setBlock(cells[i - 1].getBlock());
		}

		cells[1].setBlock(tempBlock);
	}

	/**
	 * Returns a new array of Cell objects representing the blocks in this shape
	 * along with their absolute positions.
	 */
	public Cell[] getCells()
	{
		Cell[] copy = new Cell[cells.length];

		for (int i = 0; i < copy.length; i++)
		{
			copy[i] = new Cell(cells[i]);
		}

		return copy;
	}

	/**
	 * Shifts the position of this shape down (increasing the row) by one. Used by
	 * the user when pressing the "DOWN" arrow, the game inherently (with a timer),
	 * and when a row gets filled and everything needs to collapse.
	 */
	public void shiftDown()
	{
		position.setRow(position.row() + 1);

		for (Cell c : cells)
		{
			c.setRow(c.getRow() + 1);
		}

	}

	/**
	 * Shifts the position of this shape left (decreasing the column) by one. Used
	 * by the user when pressing the "LEFT" arrow.
	 */
	public void shiftLeft()
	{
		position.setCol(position.col() - 1);

		for (Cell c : cells)
		{
			c.setCol(c.getCol() - 1);
		}

	}

	/**
	 * Shifts the position of this shape right (increasing the column) by one. Used
	 * by the user when pressing the "RIGHT" arrow.
	 */
	public void shiftRight()
	{
		position.setCol(position.col() + 1);

		for (Cell c : cells)
		{
			c.setCol(c.getCol() + 1);
		}

	}

	/**
	 * Transforms each shape counterclockwise. OTetromino will override this method
	 * to do nothing (after all, a circle rotating doesn't appear much different).
	 * SZTetromino will override this method to flip across the vertical axis and
	 * change the color from GREEN to RED.
	 */
	public void transform()
	{
		// Record the position of the row and column.
		int OGRow = position.row();
		int OGCol = position.col();

		for (Cell individualCell : cells)
		{
			// Temporarily decrease the rows and columns so it can be "centered" around
			// (0,0), for the sake of the equation (-column, row).
			individualCell.setRow(individualCell.getRow() - OGRow);
			individualCell.setCol(individualCell.getCol() - OGCol);

			// Apply the equation.
			int tempCellRowPosition = individualCell.getRow();
			individualCell.setRow(individualCell.getCol() * -1);
			individualCell.setCol(tempCellRowPosition);

			// Bring the position and row back to where they ACTUALLY are on the grid.
			individualCell.setRow(individualCell.getRow() + OGRow);
			individualCell.setCol(individualCell.getCol() + OGCol);
		}

	}

	/**
	 * Clones the abstract shape.
	 */
	@Override
	public Shape clone()
	{
		try
		{
			AbstractShape shape = (AbstractShape) super.clone();

			shape.position = new Position(position);

			shape.cells = new Cell[cells.length];

			for (int i = 0; i < cells.length; i++)
			{
				shape.cells[i] = new Cell(cells[i]);
			}

			return shape;
		}

		catch (CloneNotSupportedException e)
		{
			return null;
		}

	}

}