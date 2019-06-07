
public class Coords 
{
	int x;
	int y;
	boolean discovered = false;
	public Coords(int newX, int newY)
	{
		x = newX;
		y = newY;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public boolean getDis()
	{
		return discovered;
	}
	
	public void setDis(boolean x)
	{
		discovered = x;
	}
	public void setX(int nx)
	{
		x = nx;
	}
	
	public void setY(int ny)
	{
		y = ny;
	}
	
	
}
