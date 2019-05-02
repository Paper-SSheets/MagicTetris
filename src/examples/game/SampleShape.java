package examples.game;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;
import api.Shape;

/**
 * Partial implementation of the Shape interface for experimentation.
 */
public class SampleShape implements Shape
{
	private Position position;
	private Cell[] cells;

	public SampleShape(Position givenPosition, boolean magic)
	{
		position = givenPosition;
		cells = new Cell[2];
		cells[0] = new Cell(new Block(Color.RED, magic), givenPosition);

		// another cell just below the first one
		Position position1 = new Position(givenPosition.row() + 1, givenPosition.col());
		cells[1] = new Cell(new Block(Color.RED, false), position1);
	}

	@Override
	public Cell[] getCells()
	{
		Cell[] copy = new Cell[cells.length];
//		copy[0] = new Cell(cells[0]);
//		copy[1] = new Cell(cells[1]);
//		int i = 0;
//		for (Cell c : copy)
//		{
//			copy[i] = new Cell(cells[i]);
//			i++;
//		}
		for (int i = 0; i < copy.length; i++)
		{
			copy[i] = new Cell(cells[i]);
		}

		return copy;
	}

	@Override
	public void shiftDown()
	{
		position.setRow(position.row() + 1);
		// cells[0].setRow(cells[0].getRow() + 1);
		// cells[1].setRow(cells[1].getRow() + 1);
		for (Cell c : cells)
		{
			c.setRow(c.getRow() + 1);
		}
	}

	@Override
	public void shiftLeft()
	{
		// TODO Auto-generated method stub
		position.setCol(position.col() - 1);

		for (Cell c : cells)
		{
			c.setCol(c.getCol() - 1);
		}

	}

	@Override
	public void shiftRight()
	{
		// TODO Auto-generated method stub
		position.setCol(position.col() + 1);

		for (Cell c : cells)
		{
			c.setCol(c.getCol() + 1);
		}
	}

	@Override
	public void transform()
	{ // defaultly we will do a ccw (counter clockwise) rotation
		// TODO Auto-generated method stub
		// we need to do a -col, row, rule, and things will be good
		// if the block's position isn't 0,0 we just -x and -y, shift, then re-add

		for (Cell c : cells)
		{
			int temp = c.getRow();
			c.setRow(c.getCol() * -1);
			c.setCol(temp);
		}

	}

	@Override
	public void cycle() // shift right essentially from assign 3
	{ // TODO Auto-generated method stub

		Cell last = cells[cells.length - 1];
		System.arraycopy(cells, 0, cells, 1, cells.length - 1);
		cells[0] = last;

		// char last = letters[letters.length-1];
		// System.arraycopy(letters, 0, letters, 1, letters.length-1 );
		// letters[0] = last;

	}

	@Override
	public Shape clone()
	{
		try
		{
			// call the Object clone() method to create a shallow copy
			SampleShape s = (SampleShape) super.clone();

			// then make it into a deep copy
			s.position = new Position(position);
			s.cells = new Cell[2];
			s.cells[0] = new Cell(cells[0]);
			s.cells[1] = new Cell(cells[1]);
			return s;
		} catch (CloneNotSupportedException e)
		{
			// can't happen
			return null;
		}
	}
}
