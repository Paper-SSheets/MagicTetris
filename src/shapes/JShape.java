package shapes;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * Implementation of JShape. A JShape is an abstract shape that has initial cell
 * ordering at (0, 0): {(0, -1), (1, -1), (1, 0), (1, 1)}. The transform will be
 * ccw (the normal, inherited transform). The color of this shape will be BLUE.
 * 
 * @author SMSheets@IAState.edu - Steven Marshall Sheets
 */
public class JShape extends AbstractShape
{

	public JShape(Position position, boolean magic)
	{
		super(position);

		Cell[] temp = new Cell[4];

		temp[0] = new Cell(new Block(Color.BLUE, magic), new Position(position.row(), position.col() - 1));

		temp[1] = new Cell(new Block(Color.BLUE, false), new Position(position.row() + 1, position.col() - 1));

		temp[2] = new Cell(new Block(Color.BLUE, false), new Position(position.row() + 1, position.col()));

		temp[3] = new Cell(new Block(Color.BLUE, false), new Position(position.row() + 1, position.col() + 1));

		addCells(temp);

	}

}
