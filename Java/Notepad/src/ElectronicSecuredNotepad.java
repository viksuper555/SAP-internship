import java.util.ArrayList;
import java.util.Scanner;

public class ElectronicSecuredNotepad extends SecuredNotepad {


	private boolean running = false;
		
	

	public ElectronicSecuredNotepad(String password, ArrayList<Page> pages) {
		super(password, pages);
	}
	
	public void start() {
		if(AuthenticateUser())
			running = true;
			
	}

	public void stop() {
		if(AuthenticateUser()  && running)
			running = false;
		
	}

	public boolean isStarted() {
		if(AuthenticateUser())
			return running;		
		return false;
	}
	
	@Override
	public void AddText(int id, String text){
		if(running)
		{
			super.AddText(id, text);
		}
	}
	
	@Override
	public void ChangeText(int id, String text)
	{
		if(running)
		{
			super.ChangeText(id, text);
		}
	}
	
	public void DeleteText(int id)
	{
		if(running)
		{
			super.DeleteText(id);
		}
	}
	
	@Override
	public void PrintPage(int id)
	{
		if(running)
		{
			super.PrintPage(id);
		}
			
	}
	
	@Override
	protected Page FindPageById(int id ) {
		if(running)
		{
			Page page = super.FindPageById(id);
			return page;
		}
		return null;
	}

	@Override
	public int SearchWord(String word) {
		if(running)
		{
			super.SearchWord(word);
		}
		return -1;
		
		
	}

	@Override
	public void PrintAllPagesWithDigits() {
		if(running)
		{
			super.PrintAllPagesWithDigits();
		}
		
	}

	public void ChangePassword()
	{
		if(running)
		{
			super.ChangePassword();
		}
	}
}
