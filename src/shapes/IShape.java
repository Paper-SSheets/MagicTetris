package shapes;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * Implementation of IShape. An IShape is an abstract shape that has initial
 * cell ordering at (0, 0): {(0, 0), (1, 0), (2, 0)}. The transform will be ccw
 * (the normal, inherited transform). The color of this shape will be CYAN.
 * 
 * @author SMSheets@IAState.edu - Steven Marshall Sheets
 */
public class IShape extends AbstractShape
{

	public IShape(Position position, boolean magic)
	{
		super(position);

		Cell[] temp = new Cell[3];

		temp[0] = new Cell(new Block(Color.CYAN, magic), position);

		temp[1] = new Cell(new Block(Color.CYAN, false), new Position(position.row() + 1, position.col()));

		temp[2] = new Cell(new Block(Color.CYAN, false), new Position(position.row() + 2, position.col()));

		addCells(temp);

	}

}
