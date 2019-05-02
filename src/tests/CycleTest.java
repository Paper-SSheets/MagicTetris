package tests;

import java.util.Arrays;

public class CycleTest
{

	public static void main(String[] args)
	{
		char[] letters =
		{ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };

		shiftRight(letters);
//		shiftRight(letters);
//		shiftRight(letters);

		for (int i = 0; i < letters.length; i++)
		{
			System.out.println(letters[i]);
		}

		System.out.println(Arrays.toString(letters));
	}

	/********************************************************************************
	 * shiftRight() will move the contents of the array one slot to the right
	 ********************************************************************************/
	public static void shiftRight(char[] letters)
	{
		char last = letters[letters.length - 1];
		System.arraycopy(letters, 0, letters, 1, letters.length - 1);
		letters[0] = last;
	}
}
