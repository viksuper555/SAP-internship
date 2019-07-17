
public class Ninth {
	public static void main(String args[])		//Find 2x2 matrix with max sum
	{
		int arr[][] = {{1,2,3,4}, {5,6,1,8}, {1,3,5,7}, {3,5,5,5}}, maxSum = 0, nums[] = new int[4];
		
		for(int i = 0; i < arr.length-1; i++)
		{
			for(int j = 0; j < arr[i].length - 1; j++)
			{
				int sum = arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i+1][j+1];
				if(sum > maxSum)
				{
					maxSum = sum;
					nums[0] = arr[i][j];
					nums[1] = arr[i][j+1];
					nums[2] = arr[i+1][j];
					nums[3] = arr[i+1][j+1];
				}
			}
		}
		for(int i = 0; i < 3; i+=2)
		{
			System.out.print(nums[i] + " " + nums[i+1]);
			System.out.println();
		}
		
	}
}

