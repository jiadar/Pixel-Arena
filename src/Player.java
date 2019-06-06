
public class Player {
	int health = 100;
	int attack = 10;
	int defense = 5;
	int playerX = 39;
	int playerY = 2;
	int playerGold;
	
	private final int MAX_HEALTH = 100;
	
	public Player(int y, int x)
	{
		playerX = x;
		playerY = y;
	}
	
	public Coords getLoc() {return new Coords(playerX, playerY);}
	
	public void setGold(int gold) { playerGold = gold; }
	public void setHealth(int h) {health = h;}
	public void setAttack(int a) 
	{
		attack = a;
		System.out.println("SETTING ATTACK: " + attack);
	}
	public void setDefense(int d) {defense = d;}
	
	public int getGold() {return playerGold;}
	public int getHealth() {return health;}
	public int getAttack() {return attack;}
	public int getDefense() {return defense;}
	
	public void addGold(int gold) { playerGold += gold; }

	public void move(String xy, int num)
	{
		
	}
}