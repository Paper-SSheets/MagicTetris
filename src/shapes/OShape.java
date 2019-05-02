package shapes;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * Implementation of OShape. An OShape is an abstract shape that has initial
 * cell ordering at (0, 0): {(0, 0), (0, 1), (1, 0), (1, 1)}. The transform
 * method will do nothing for this shape. The color of this shape will be
 * YELLOW.
 * 
 * @author SMSheets@IAState.edu - Steven Marshall Sheets
 */
public class OShape extends AbstractShape
{

	public OShape(Position position, boolean magic)
	{
		super(position);

		Cell[] temp = new Cell[4];

		temp[0] = new Cell(new Block(Color.YELLOW, magic), position);

		temp[1] = new Cell(new Block(Color.YELLOW, false), new Position(position.row(), position.col() + 1));

		temp[2] = new Cell(new Block(Color.YELLOW, false), new Position(position.row() + 1, position.col()));

		temp[3] = new Cell(new Block(Color.YELLOW, false), new Position(position.row() + 1, position.col() + 1));

		addCells(temp);
	}

	/**
	 * OTetromino will override the original transform method to do nothing (after
	 * all, a circle rotating doesn't appear much different).
	 */
	@Override
	public void transform()
	{
		// Do nothing here. This is just an O.
	}

}