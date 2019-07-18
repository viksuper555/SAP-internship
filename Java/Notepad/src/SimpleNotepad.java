import java.util.ArrayList;

public class SimpleNotepad implements INotepad{
	
	ArrayList<Page> pages = new ArrayList<Page>();

	public SimpleNotepad(ArrayList<Page> pages){
		this.pages = pages;
	}
		
	@Override
	public void AddText(int id, String text){
		Page page = FindPageById(id);
		page.AddText(text);
		pages.add(id, page);
		
	}	
	
	@Override
	public void ChangeText(int id, String text)
	{
		Page page = FindPageById(id);
		page.DeleteText();
		page.AddText(text);
		pages.add(id, page);
	}	
	
	@Override
	public void DeleteText(int id)
	{
		Page page = FindPageById(id);
		page.DeleteText();
		pages.add(id, page);
	}

	@Override
	public void PrintPage(int id)
	{
		Page page = FindPageById(id);
		page.toString();
	}
	
	private Page FindPageById(int id ) {	
		Page page = null;
		for(Page var : pages)
		{
			if(var.getId() == id)
			{
				page = var;
				break;
			}
				
		}
		return page;
	}

	
	@Override
	public int SearchWord(String word) {
		for(Page page : pages)
		{
			if(page.SearchWord(word) != -1)
			{
				return page.getId();
			}
		}
		return -1;
		
	}

	
	@Override
	public void PrintAllPagesWithDigits() {
		
		for(Page page : pages)
		{
			if(page.ContainsDigits())
			{
				System.out.println(page.toString());
			}
		}
		
	}

	
	
}
