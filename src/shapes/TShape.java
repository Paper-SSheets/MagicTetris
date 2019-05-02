package shapes;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * Implementation of TShape. A TShape is an abstract shape that has initial cell
 * ordering at (0, 0): {(-1, 0), (0, -1), (0, 0), (0, 1)}. The transform will be
 * ccw (the normal, inherited transform). The color of this shape will be
 * MAGENTA.
 * 
 * @author SMSheets@IAState.edu - Steven Marshall Sheets
 */
public class TShape extends AbstractShape
{

	public TShape(Position position, boolean magic)
	{
		super(position);

		Cell[] temp = new Cell[4];

		temp[0] = new Cell(new Block(Color.MAGENTA, magic), new Position(position.row() - 1, position.col()));

		temp[1] = new Cell(new Block(Color.MAGENTA, false), new Position(position.row(), position.col() - 1));

		temp[2] = new Cell(new Block(Color.MAGENTA, false), position);

		temp[3] = new Cell(new Block(Color.MAGENTA, false), new Position(position.row(), position.col() + 1));

		addCells(temp);
	}

}