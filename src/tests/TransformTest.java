package tests;

public class TransformTest
{

	public static void main(String[] args)
	{
		int x = -2;
		int y = -1;
		swap(x, y);
	}

	public static void swap(int x, int y)
	{
		int temp = x;
		x = y * -1;
		y = temp;
		System.out.println(x);
		System.out.println(y);
	}

}
