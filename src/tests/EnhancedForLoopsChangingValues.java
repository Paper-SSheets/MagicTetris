package tests;

import java.util.Arrays;

public class EnhancedForLoopsChangingValues
{

	public static void main(String[] args)
	{
		int[] values =
		{ 0, 1, 2, 3, 4, 5 };

		// Without an index variable
		for (@SuppressWarnings("unused")
		int integer : values)
		{
			integer *= 2;
		}
		System.out.println(Arrays.toString(values));

		// with an index variable enhanced
//		int i = 0;
//		for (int integer : values)
//		{
//			values[i] *= 2;
//			i++;
//		}
//		System.out.println(Arrays.toString(values));

		// with an index variable normal
//		for (int i = 0; i < values.length; i++)
//		{
//			values[i] *= 2;
//		}
//		System.out.println(Arrays.toString(values));
	}
}
