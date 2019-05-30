
public class gameTile extends Tile
{
	int tileId = 0;
	boolean passable;
	
	public gameTile(int id, boolean p)
	{
		tileId = id;
		passable = p;
	}
	
	public String getTileName() 
	{
		return null;
	}

	public boolean isPassable() 
	{
		return false;
	}

	public int getTileId() 
	{
		return tileId;
	}

	public boolean hasSeen() 
	{
		return false;
	}

}
