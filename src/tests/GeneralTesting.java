package tests;


import java.util.Random;

public class GeneralTesting
{

	public static void main(String[] args)
	{
		Random RNG = new Random();
		String[] whatShapeToChoose =
		{ "I", "J", "L", "O", "SZ", "T" };
		@SuppressWarnings("unused")
		String nextShape = whatShapeToChoose[RNG.nextInt(whatShapeToChoose.length)];
		/*
		 * while (true) { nextShape =
		 * whatShapeToChoose[RNG.nextInt(whatShapeToChoose.length)];
		 * System.out.println(nextShape);s }
		 */

		int[] iveGotTheMagicInMe =
		{ 1, 2, 3, 4, 5 };

		// int x = RNG.nextInt(iveGotTheMagicInMe.length);

		int y = iveGotTheMagicInMe[RNG.nextInt(iveGotTheMagicInMe.length)];
		while (true)
		{
			y = iveGotTheMagicInMe[RNG.nextInt(iveGotTheMagicInMe.length)];
			System.out.println(y);
		}
	}

}
