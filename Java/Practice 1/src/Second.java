public class Second {
	public static void main(String[] args) {		//Check if an array is Jagged
		int arr[] = {1,2,3,4}, counter = 0;
		
		for(int i = 1; i < arr.length-1;i++)
		{
			if(arr[i] < arr[i-1] || arr[i] > arr[i+1])
			{
				System.out.print("Not a Jagged Array");
				break;
			}
			counter++;
		}
		if(counter == arr.length-2)
		{
			System.out.print("Jagged Array");
		}
	}
}
