
public class Monster 
{
	int attack = 0;
	int health = 0;
	int x;
	int y;
	
	
	public Monster(int h, int a, int monX, int monY)
	{
		attack = a;
		health = h;
		x = monX;
		y = monY;
	}
	public Coords getLoc() {return new Coords(x, y);}
	public void setHealth(int h) {health = h;}
	public void setAttack(int a) {attack = a;}

	public int getHealth() {return health;}
	public int getAttack() {return attack;}
}
