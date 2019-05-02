package shapes;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * Implementation of LShape. An LShape is an abstract shape that has initial
 * cell ordering at (0, 0): {(0, 0), (1, -2), (1, -1), (1, 0)}. The transform
 * will be ccw (the normal, inherited transform). The color of this shape will
 * be ORANGE.
 * 
 * @author SMSheets@IAState.edu - Steven Marshall Sheets
 */
public class LShape extends AbstractShape
{

	public LShape(Position position, boolean magic)
	{
		super(position);

		Cell[] temp = new Cell[4];

		temp[0] = new Cell(new Block(Color.ORANGE, magic), position);

		temp[1] = new Cell(new Block(Color.ORANGE, false), new Position(position.row() + 1, position.col() - 2));

		temp[2] = new Cell(new Block(Color.ORANGE, false), new Position(position.row() + 1, position.col() - 1));

		temp[3] = new Cell(new Block(Color.ORANGE, false), new Position(position.row() + 1, position.col()));

		addCells(temp);

	}

}