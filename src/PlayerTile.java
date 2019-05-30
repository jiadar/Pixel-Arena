
public class PlayerTile extends Tile
{
	int tileId = 5;
	boolean passable;
	@Override
	public String getTileName() {
		// TODO Auto-generated method stub
		return "p";
	}

	@Override
	public boolean isPassable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTileId() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public boolean hasSeen() {
		// TODO Auto-generated method stub
		return false;
	}

}
