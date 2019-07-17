import java.util.HashMap;

public class TaskTen {		//Find the most frequent element in an array
	public static void main(String args[])
	{
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int arr[] = {4, 1, 1, 4, 2, 3,4, 4, 1, 2, 4, 9, 3}, maxCount = 0, digit = 0;
		
		for(int i = 0; i < arr.length; i++)
		{
			if(map.get(arr[i]) == null)
				map.put(arr[i], 0);
			map.put(arr[i], map.get(arr[i]) + 1);
		}
	for(var entry : map.entrySet())
	{
		if(entry.getValue() > maxCount)
		{
			maxCount = entry.getValue();
			digit = entry.getKey();
		}
	}
	System.out.print(digit + " (" + maxCount + " times).");
	}
}
