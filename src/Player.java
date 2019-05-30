
public class Player {
	int health = 100;
	int attack = 10;
	int defense = 5;
	int playerX = 39;
	int playerY = 2;
	int playerGold;
	
	private final int MAX_HEALTH = 100;
	
	public Player(int h, int a, int d)
	{
		health = h;
		attack = a;
		defense = d;
	}
	
	public Coords plyrLoc() {return new Coords(playerX, playerY);}
	public void setGold(int gold) { playerGold = gold; }
	public void addGold(int gold) { playerGold += gold; }
	public int getGold() { return playerGold; }
	public void move(String xy, int num)
	{
		if(xy.equals("x"))
			playerX += num;
		else if(xy.equals("y"))
			playerY += num;
	}
}