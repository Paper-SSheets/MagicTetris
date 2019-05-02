package shapes;

import java.util.ArrayList;
import java.util.List;

import api.AbstractGame;
import api.Position;

/**
 * MagicTetris implementation.
 * 
 * @author SMSheets@IAState.edu - Steven Marshall Sheets
 */
public class MagicTetris extends AbstractGame
{
	/**
	 * When the game enters gravityMode, all blocks with empty cells below them are
	 * allowed to "fall" independently. This often results in some more completed
	 * rows, which are then collapsed as usual in the next step. Gravity mode can be
	 * achieved by filling a row with at three or more "magic" blocks.
	 */
	private Boolean gravityMode = false;

	/**
	 * Initially, the player starts out with a score of zero. By playing the game,
	 * their score will increase. Game on!
	 */
	private int totalScore = 0;

	/**
	 * Constructs a game with the given width (columns) and height (rows). This game
	 * will use a new instance of BasicGenerator to generate new shapes.
	 * 
	 * @param width  width of the game grid (number of columns)
	 * @param height height of the game grid (number of rows)
	 */
	public MagicTetris(int width, int height)
	{
		super(width, height, new BasicGenerator());
	}

	@Override
	public List<Position> determinePositionsToCollapse()
	{
		List<Position> positionsToCollapse = new ArrayList<Position>();

		if (gravityMode)
		{
			for (int row = getHeight() - 1; row >= 0; row--)
			{
				for (int column = 0; column < getWidth(); column++)
				{
					// Once we reach a sad block that has yet to be filled with color, we need to
					// climb up the column.
					if (getBlock(row, column) == null)
					{
						for (int rowsClimbingUp = row; rowsClimbingUp >= 0; rowsClimbingUp--)
						{
							// If we reach a colored block we want that block to FALL TO THE FLOOR (until it
							// hits another colored block or the ground).
							if (getBlock(rowsClimbingUp, column) != null)
							{
								for (rowsClimbingUp = rowsClimbingUp + 1; rowsClimbingUp <= row; rowsClimbingUp++)
								{
									positionsToCollapse.add(new Position(rowsClimbingUp, column));
								}
								// Move on to the next column.
								break;
							}
						}
					}
				}
			}
			// Sadly, we can only be in gravity mode for a fleeting moment. All good things
			// must come to an end.
			gravityMode = false;
		} else
		{
			for (int row = getHeight() - 1; row >= 0; row--)
			{
				int coloredCells = 0;
				int blocksThatGotTheMagicInThem = 0;

				for (int column = 0; column < getWidth(); column++)
				{
					if (getBlock(row, column) != null)
					{
						coloredCells++;
						if (getBlock(row, column).isMagic())
						{
							blocksThatGotTheMagicInThem++;
						}
					}
				}

				// If the row is filled with color!
				if (coloredCells == getWidth())
				{
					if (blocksThatGotTheMagicInThem >= 3)
					{
						gravityMode = true;
					}
					for (int column = 0; column < getWidth(); column++)
					{
						positionsToCollapse.add(new Position(row, column));
					}

					totalScore += (int) Math.pow(2, blocksThatGotTheMagicInThem);
				}
			}
		}
		return positionsToCollapse;
	}

	@Override
	public int determineScore()
	{
		return totalScore;
	}

}