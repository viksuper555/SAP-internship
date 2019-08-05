
public class Node implements Comparable<Node>{

	public String c;
	
	public boolean Known = false;
	
	public Node(){}

	public Node(String c)
	{
		this.c = c;
	}

	@Override
	public int compareTo(Node o) {
		return c.compareTo(o.c);
	}

}
