public class Page {

	private String heading = new String(), text = new String();
	
	private int id;
	
	public int getId(){
		return this.id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	public Page(int id, String heading, String text)
	{
		this.id = id;
		this.heading = heading;
		this.text = text;
	}
	public void AddText(String text)
	{
		if(this.text != null)
		{
			this.text +=text;
		}
		else {
			this.text = text;
		}
	}
	public void DeleteText()
	{
		this.text = null;
	}
	
	@Override
	public String toString() {
		return heading + "\n" + text;
	}
	
	public int SearchWord(String word) 
	{
		if(text.contains(word))
			return text.indexOf(word);
		return -1;
	}
	
	public boolean ContainsDigits() 
	{
		for(char c : text.toCharArray())
		{
			if(Character.isDigit(c))
				return true;
		}
		return false;
	}
	
}
