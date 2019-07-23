
public class Rocket {
	
	public int posX, posY;
	public Trace trace = new Trace(0);
	
	public Rocket(int posX, int posY, int distance)
	{
		this.posX = posX;
		this.posY = posY;
		this.trace.distance = distance;
		
	}
	
	
}
