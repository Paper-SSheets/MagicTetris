package shapes;

import java.util.Random;

import api.Generator;
import api.Position;
import api.Shape;

/**
 * Generator for Shape objects in MagicTetris. All six shapes are equally
 * likely, and the generated shape is magic with 20% probability.
 * 
 * @author SMSheets@IAState.edu - Steven Marshall Sheets
 */
public class BasicGenerator implements Generator
{
	@Override
	public Shape getNext(int width)
	{
		// Each shape will be selected with a 1/6 probability.
		String[] whatShapeToChoose =
		{ "I", "J", "L", "O", "SZ", "T" };

		// Each block will be "magic" with a 1/5 probability.
		int[] iveGotTheMagicInMe =
		{ 1, 2, 3, 4, 5 };

		String nextShape = whatShapeToChoose[new Random().nextInt(whatShapeToChoose.length)];

		// The shape that has yet to be formed.
		AbstractShape shape = null;

		// Defaultly, the blocks have no magic in them. :(
		boolean magic = false;

		// But if they're lucky, they will have magic in them with a 20% probability.
		if (iveGotTheMagicInMe[new Random().nextInt(iveGotTheMagicInMe.length)] == 1)
		{
			magic = true;
		}

		// Production of the shapes.
		if (nextShape.equals("I"))
		{
			shape = new IShape(new Position(-2, width / 2), magic);
		} else if (nextShape.equals("J"))
		{
			shape = new JShape(new Position(-1, width / 2), magic);
		} else if (nextShape.equals("L"))
		{
			shape = new LShape(new Position(-1, (width / 2) + 1), magic);
		} else if (nextShape.equals("O"))
		{
			shape = new OShape(new Position(-1, width / 2), magic);
		} else if (nextShape.equals("SZ"))
		{
			shape = new SZShape(new Position(-1, width / 2), magic);
		} else if (nextShape.equals("T"))
		{
			shape = new TShape(new Position(0, width / 2), magic);
		}

		return shape;
	}

}