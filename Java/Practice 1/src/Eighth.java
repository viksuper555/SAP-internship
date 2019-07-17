
public class Eighth {
	public static void main(String args[])		//Check if true above second diagonal
	{
		boolean arr[][] = {{false,false,false,true}, {false,false,true,true}, {false,true,true,true}};
		
		if(CheckArray(arr))
			System.out.print("True above diagonal");
		else
			System.out.print("Only false above diagonal");
	}
	
	public static boolean CheckArray(boolean arr[][])
	{
		int len = Math.min(arr.length, arr[0].length);
		
		for(int i = 0;i < len;i++)
		{
			for(int j = arr[i].length -2 -i; j >= 0 ; j--)
			{
				if(arr[i][j])
					return true;
			}
		}
		return false;
	}
}