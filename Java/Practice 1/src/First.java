
public class First {
	public static void main(String[] args) {		//Check if all numbers in
													// an array are negative
		int arr[] = {-1,-2,-3,-4}, counter = 0;
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]<0)
				counter++;
		};
		
		if(counter  == arr.length)
			System.out.print("All numbers are negative");
		else
			System.out.print("Some are positive");
	}
}
