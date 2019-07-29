import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Trie {

	TrieNode root;
	
	public Trie()
	{
		root = new TrieNode();
	}
	
	public void AddWord(String word)
	{
		HashMap<Character, TrieNode> children = root.getChildren();
		
		for(int i = 0;i< word.length(); i++)
		{
			TrieNode node;
			char c = word.charAt(i);
			
			if(children.containsKey(c)) 
                node = children.get(c);
			else 
			{ 
                node = new TrieNode(c);
                children.put(c, node);
            }
			
            children = node.getChildren();

            if(i == word.length() - 1) 
            {
                node.setLast(true);
            }
			
		}
		
	}

	public boolean CheckWord(String word)
	{
		HashMap<Character, TrieNode> children = root.getChildren();
		TrieNode node = null;
		
		for(int i = 0; i < word.length(); i ++)
		{
			char c = word.charAt(i);
			if(children.containsKey(c))
			{
				node = children.get(c);
				children = node.getChildren();
			}
			else 
			{
				node = null;
				break;
			}
		}
		if(node != null && node.isLast())
		{
			return true;
		}
		else
		{
			return false; 
		}
	}

	 private List<String> result = new ArrayList<String>();
	 
	 private List<String> getAllWords()
	 {
		 generateAllWords(result,"", root);
		 
		 return result;
	 }
	 
	private void generateAllWords(List<String> result, String word, TrieNode root) 
	{
		 HashMap<Character, TrieNode> children = root.getChildren();
		 
		    if (root.c != null && root.isLast()) {
		      result.add(word);
		    }
		    for (Map.Entry<Character, TrieNode> entry : children.entrySet()) {
		      if (entry != null) {
		    	  generateAllWords(result, word + entry.getKey(), entry.getValue());
		      }
		    }
	}
	@Test
	public void getAllWordsTest()
	{
		Trie trie = new Trie();
		trie.AddWord("Tree");
		trie.AddWord("Treesome");
		trie.AddWord("Try");
		List<String> list = trie.getAllWords();
		List<String> testList = new ArrayList<String>();
		testList.add("Tree");
		testList.add("Treesome");
		testList.add("Try");
		assertTrue(list.equals(testList));
	}
	 
	 
	@Test
	public void checkRootCreation() {
	    Trie trie = new Trie();
	 
	    assertTrue(trie.root != null);
	}
	
	@Test
	public void checkInsert_and_searchWord(){
		Trie trie = new Trie();
		trie.AddWord("word");
		assertTrue(trie.CheckWord("word"));
	}
}
