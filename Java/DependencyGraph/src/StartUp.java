import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class StartUp {

	public static void main(String args[])
	{
		HashMap<String, ArrayList<String>> dep = new HashMap<>();
		ArrayList<Node> nodes = new ArrayList<Node>();
		ArrayList<String> chars = new ArrayList<String>();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter N: ");			//Input
		int n = scan.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			System.out.printf("Pair No %d \n", i+1);
			System.out.println("Enter first Node: ");
			String ch = scan.next();
			Node node = new Node(ch);
			
			System.out.println("Enter second Node: ");
			String ch2 = scan.next();
			Node node2 = new Node(ch2);
			
			if(dep.containsKey(ch))
			{
				dep.get(ch).add(ch2);
			}
			else
			{
				var list1 = new ArrayList<String>();
				list1.add(ch2);
				dep.put(ch, list1);
			}
			
			if(!nodes.contains(node))
				nodes.add(node);
			if(!nodes.contains(node2))
				nodes.add(node2);
		}
		scan.close();					//End of input
		
		
		Node currNode = nodes.get(0);							
		Node parentNode = currNode;					
		
		while(true)				
		{
				for(Node node : nodes)							
				{
						if(!dep.get(currNode.c).isEmpty())							
						{
							if(dep.get(currNode.c).contains(node.c))			//Searching for Node children
							{
								parentNode = node;	
								break;
							}
						}
						else														//If no children, add parent
						{
							if(node.Known == false)
								parentNode = node;
							break;
						}
				}
				
				if(!dep.containsKey(parentNode.c) || dep.get(parentNode.c).isEmpty())			//Known node
				{
					parentNode.Known = true;
					
					for(Entry<String, ArrayList<String>> entry : dep.entrySet())	//Remove Known node from requirements
					{
						entry.getValue().remove(parentNode.c);
					}
					chars.add(parentNode.c);
					dep.remove(parentNode.c);
					for(Node node : nodes)
					{
						if(node.Known == false)
						{
							currNode = node;
							break;
						}
					}
				}

				else
					currNode = parentNode;
			
				if(dep.isEmpty())
				{
					System.out.print(chars);
					break;
				}
		}
		
	}
}
