
public interface INotepad {
		
	void AddText(int id, String text);
	
	void ChangeText(int id, String text);
		
	void DeleteText(int id);

	void PrintPage(int id);
	
	int SearchWord(String word);
	
	void PrintAllPagesWithDigits();
}
