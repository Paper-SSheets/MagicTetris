package shapes;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * Implementation of SZShape. An SZShape is an abstract shape that has initial
 * cell ordering at (0, 0): {(0, 0), (1, 0), (1, 1), (2, 1)}. The transform
 * method will flip this shape across the vertical axis and change its color
 * from GREEN (initially) to RED (once flipped).
 * 
 * @author SMSheets@IAState.edu - Steven Marshall Sheets
 */
public class SZShape extends AbstractShape
{

	public SZShape(Position position, boolean magic)
	{
		super(position);

		Cell[] temp = new Cell[4];

		temp[0] = new Cell(new Block(Color.GREEN, magic), position);

		temp[1] = new Cell(new Block(Color.GREEN, false), new Position(position.row() + 1, position.col()));

		temp[2] = new Cell(new Block(Color.GREEN, false), new Position(position.row() + 1, position.col() + 1));

		temp[3] = new Cell(new Block(Color.GREEN, false), new Position(position.row() + 2, position.col() + 1));

		addCells(temp);
	}

	/**
	 * SZTetromino will override the original transform method to flip across the
	 * vertical axis and change the color from GREEN to RED.
	 */
	@Override
	public void transform()
	{
		Cell[] temp = getCells();

		// Really this could be any block, but why not just the first one?
		if (temp[0].getBlock().toString().equals("GREEN") || temp[0].getBlock().toString().equals("GREEN*"))
		{
			temp[0].setCol(temp[0].getCol() + 1);
			temp[1].setCol(temp[1].getCol() + 1);
			temp[2].setCol(temp[2].getCol() - 1);
			temp[3].setCol(temp[3].getCol() - 1);
			for (int i = 0; i < temp.length; i++)
			{
				temp[i].setBlock(new Block(Color.RED, temp[i].getBlock().isMagic()));
			}

		}

		else
		{
			temp[0].setCol(temp[0].getCol() - 1);
			temp[1].setCol(temp[1].getCol() - 1);
			temp[2].setCol(temp[2].getCol() + 1);
			temp[3].setCol(temp[3].getCol() + 1);
			for (int i = 0; i < temp.length; i++)
			{
				temp[i].setBlock(new Block(Color.GREEN, temp[i].getBlock().isMagic()));
			}

		}

		addCells(temp);

	}

}