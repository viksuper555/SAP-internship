import java.util.HashMap;

public class TrieNode {
	public Character c;
	private HashMap<Character,TrieNode> children = new HashMap<>();
	private boolean isLast = false;
	
	
	public TrieNode(){}
	
	public TrieNode(char c)
	{
		this.c = c;
	}
	
	public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean isLast) {
        this.isLast = isLast;
    }
	
}
