import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map 
{
	private Tile[][] map = new Tile[50][50];
	private ArrayList<Integer> mapId = new ArrayList<Integer>();
	File file = new File("map.txt");
	
	public Map() throws IOException
	{
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext())
		{
			mapId.add(scanner.nextInt());
		}
	    create(mapId);
	}
	
	public void showMap()
	{
		for(int r = 0; r < map.length; r++)
		{
			for(int c = 0; c < map[0].length; c++)
			{
				System.out.print(map[r][c].getTileId());
			}
			System.out.println();
		}
	}
	
	private void create(ArrayList<Integer> arr)
	{
		int n = 0;
		for(int r = 0; r < map.length; r++)
		{	for(int c = 0; c < map[0].length; c++)
			{
				map[r][c] = new gameTile(arr.get(n), arr.get(n) == 1);
				n++;
			}
		}
	}
	
	public void swap(Coords c, Coords nc)
	{
		Coords temp = new Coords(c.getY(),c.getX());
		map[c.getY()][c.getX()] = map[nc.getX()][nc.getY()];
		map[nc.getY()][nc.getX()] = map[temp.getY()][temp.getX()];
	}
	
	public void set(Coords c, PlayerTile nt)
	{
		map[c.getY()][c.getX()] = nt;
	}
}
