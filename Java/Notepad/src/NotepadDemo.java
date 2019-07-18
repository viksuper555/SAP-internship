import java.util.ArrayList;

public class NotepadDemo {

	public static void main(String args[])
	{
		Page page1 = new Page(0, "Heading1","Lorem Ipsum");
		Page page2 = new Page(1, "Heading2","LOREM IPSUM"); 
		ArrayList<Page> pages = new ArrayList<Page>();
		pages.add(page1); 		
		pages.add(page2);
		
		ElectronicSecuredNotepad pad = new ElectronicSecuredNotepad("Pass1", pages);
		
		pad.start();
		
		pad.PrintPage(0);
		
		pad.ChangePassword();

		pad.PrintPage(0);
		
		pad.Shutdown();
	}
}
