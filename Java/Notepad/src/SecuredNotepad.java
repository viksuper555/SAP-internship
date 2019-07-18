import java.util.ArrayList;
import java.util.Scanner;

public class SecuredNotepad implements INotepad{
	
	private ArrayList<Page> pages = new ArrayList<Page>();

	private String password;
	
	private Scanner scan = new Scanner(System.in);
	public SecuredNotepad(String password, ArrayList<Page> pages) {
		this.pages = pages;
		if(!ValidPassword(password))
			throw new IllegalArgumentException("The password is too weak!");
		this.password = password;
	}

	@Override
	public void AddText(int id, String text){
		if(AuthenticateUser())
		{
			System.out.println("Access granted!");
			Page page = FindPageById(id);
			page.AddText(text);
			pages.add(id, page);
		}
	}	
	
	@Override
	public void ChangeText(int id, String text)
	{
		if(AuthenticateUser())
		{
			Page page = FindPageById(id);
			page.DeleteText();
			page.AddText(text);
			pages.remove(id);
			pages.add(id, page);
		}
		
	}	
	
	@Override
	public void DeleteText(int id)
	{
		if(AuthenticateUser())
		{
			Page page = FindPageById(id);
			page.DeleteText();
			pages.add(id, page);
		}
	}
	
	@Override
	public void PrintPage(int id)
	{
		if(AuthenticateUser())
		{
			Page page = FindPageById(id);
			System.out.println(page.toString());
		}
			
	}
	
	protected Page FindPageById(int id ) {
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
		if(AuthenticateUser())
		{
			for(Page page : pages)
			{
				if(page.SearchWord(word) != -1)
				{
					return page.getId();
				}
			}
		}
		return -1;
		
		
	}

	@Override
	public void PrintAllPagesWithDigits() {
		if(AuthenticateUser())
		{
			for(Page page : pages)
			{
				if(page.ContainsDigits())
				{
					System.out.println(page.toString());
				}
			}
		}	
		
	}

	protected boolean AuthenticateUser()
	{
		System.out.println("Enter password:");
		String inputPassword = scan.nextLine();
        
		if(inputPassword.equals(password))
		{
			System.out.println("Access granted!");
			return true;
		}
		else
		{

			System.out.println("Access denied!");
			return false;
		}
		
	}

	public void ChangePassword() 
	{
		if(AuthenticateUser())
		{
			System.out.println("Enter new password:");
			String inputPassword = scan.nextLine();
			if(!ValidPassword(inputPassword))
				throw new IllegalArgumentException("The password is too weak!");
			System.out.println("Repeat new password:");
			String inputPassword2 = scan.nextLine();
			
			if(inputPassword.compareTo(inputPassword2) == 0)
				this.password = inputPassword;
			else 
				System.out.println("Wrong password repeat. Password not changed");
		}
	}
	
	private boolean ValidPassword(String password)
	{
		return !(password.length() < 5 || password.equals(password.toUpperCase()) || password.equals(password.toLowerCase()) || !password.matches(".*\\d.*"));
	}
	
	public void Shutdown()
	{
		scan.close();
	}
}
