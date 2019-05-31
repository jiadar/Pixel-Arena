//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class Game implements KeyListener, ActionListener
//{
//	private static Player p = new Player(100,10,5);
//	static Map map;
//	
//	public static void main(String[] args) 
//	{
//		new Game();
//	}
//	
//	public Game()
//	{
//		setUpMap();
//		//play();
//	}
//	public static void setUpMap()
//	{
//		try 
//		{
//			map = new Map();
//			map.set(new Coords(p.playerY,p.playerX), new PlayerTile());
//			map.showMap();
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//	}
//	
//	public static void play()
//	{
//		Scanner input = new Scanner(System.in);
//		String str = input.next();
//		Coords strt = new Coords(p.playerX, p.playerY);
//		if(str.equals("Left"))
//		{
//			p.move("y", -1);
//			System.out.println(p.plyrLoc().getY() + " , " + p.plyrLoc().getX());
//		}
//		//right
//
//		if(str.equals("Right"))
//		{
//			p.move("y", 1);
//			System.out.println(p.plyrLoc().getY() + " , " + p.plyrLoc().getX());
//		}
//		//up
//
//		if(str.equals("Up"))
//		{
//			p.move("x", -1);
//			System.out.println(p.plyrLoc().getY() + " , " + p.plyrLoc().getX());
//		}
//		
//		//down
//
//		if(str.equals("Down"))
//		{
//			p.move("x", 1);
//			System.out.println(p.plyrLoc().getY() + " , " + p.plyrLoc().getX());
//		}
//		map.swap(strt, new Coords(p.plyrLoc().getY(), p.plyrLoc().getX()));
//		map.showMap();
//	}
//	
//	
//	@Override
//	public void keyTyped(KeyEvent e) 
//	{
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void keyPressed(KeyEvent e) 
//	{
//		//left
//		if(e.getKeyCode() == 37)
//		{
//			p.move("y", -1);
//		}
//		//right
//		if(e.getKeyCode() == 39)
//		{
//			p.move("y", 1);
//		}
//		//up
//		if(e.getKeyCode() == 38)
//		{
//			p.move("x", -1);
//		}
//		//down
//		if(e.getKeyCode() == 40)
//		{
//			p.move("x", 1);
//		}
//		
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) 
//	{
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	
//
//}

import java.util.Random;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Game {

   // Set up swing window elements
   
   private JFrame frm = new JFrame("Game");
   private JTextArea txtArea1 = new JTextArea();
   private Font font = new Font("monospaced", Font.PLAIN, 36);
   private JScrollPane scrollPane = new JScrollPane();
   private final String LINE_SEPARATOR = System.lineSeparator();
   private JTextArea txtArea2 = new JTextArea();

   // this will track the position of the player character
   private int pos_x = 0;
   private int pos_y = 0;

   private int monster_x = 1;
   private int monster_y = 2;
   
   // this will be the size of the grid
   private static int GRID_SIZE = 10;

   // define the grid - this should be defined eventually with the
   // objects you created to define the grid
   private static final char[][] gamemap = new char[][]{
      { '.', '.', '.', '.', '.', '|', '|', '.', '.', '.'},
      { '.', '|', '.', '|', '.', '.', '.', '.', '|', '.'},
      { '.', '|', '.', '.', '.', '.', '.', '.', '.', '.'},
      { '.', '.', '.', '|', '|', '|', '.', '|', '.', '|'},
      { '.', '.', '.', '|', '.', '.', '.', '|', '.', '.'},
      { '.', '|', '.', '.', '.', '|', '.', '|', '|', '.'},
      { '.', '|', '|', '|', '.', '|', '.', '.', '.', '.'},
      { '.', '.', '.', '|', '.', '.', '.', '.', '.', '.'},
      { '.', '|', '.', '.', '.', '.', '|', '|', '|', '.'},
      { '.', '.', '.', '|', '|', '.', '.', '.', '.', '.'},
   };

   // what character to use for the player character 
   private static final char player = 'X';
   private static final char monster = 'M';
   
   // Use a timer to make a background event loop
   // the background loop will execute every TIMER_INTERVAL from the
   // action performed method below
   private static final int TIMER_INTERVAL = 1000;
   private Timer timer;
      
   // here we set up the window, key listener event loop, and text area
   private Game() 
   {
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      frm.getContentPane().add(txtArea2);
      frm.getContentPane().add(scrollPane);
      
      scrollPane.setViewportView(txtArea1);
    
      txtArea1.addKeyListener(new KeyListener());
      txtArea1.setFont(font);
      txtArea1.setEditable(false);
      
      txtArea2.setFont(font.deriveFont((float) 0.04));;;
      txtArea2.setLocation(50, 10);
      txtArea2.setEditable(false);
      
      timer = new Timer(TIMER_INTERVAL, new TimerListener());
      timer.start();
   }

   // open the initial window and show the game map
   // we can call this from the instance runner
   public void open(final int xLocation, final int yLocation, final int width,
                    final int height) 
   {
      SwingUtilities.invokeLater(new Runnable() 
      {
            public void run() 
            {
               frm.setBounds(xLocation, yLocation, width, height);
               showMap();
               frm.setVisible(true);
            }
         });
   }


   //close the window
   public void close() 
   {
      frm.dispose();
   }

   // update the map. we will call this in the keypress loop to update
   // the position of the player character, monsters, and other items
   private void updateMap() 
   {
      txtArea1.setText("");
      txtArea2.setText("Health: " + "\n Attack: " + "\n Defense: ");
      showMap();
   }

   // show the map. we print the static game map. if the player character
   // is in a particular square (x,y) we print the player character instead
   // same technique could be used for monsters
   private void showMap() {
      String txt = "";
      for (int i = 0; i < GRID_SIZE; i++) {
         for (int j = 0; j < GRID_SIZE; j++) {
            // mark the player first
            if (pos_x == j && pos_y == i) {
               txt = txt + player;     
            }
            else {
               // if it's not the player, but it is the monster, mark the monster
               if (monster_x == j && monster_y == i) {
                  txt = txt + monster;                  
               }
               // if it's not the player or monster, mark the game map
               else txt = txt + gamemap[i][j];
            }  
         }
         txt = txt + LINE_SEPARATOR;
      }   
      txtArea1.setText(txt);
   }

   // update the position of the player character using the arrow keys
   // any other keys will be ignored
   // if there are other keys you want to use, System.out.println keycode
   // to the console and use that code in the case to do what you want
   private void updatePosition(int keyCode) {
      // Left 37, Up 38, Right 39, Down 40   
      switch (keyCode) {
      case 37: if( gamemap[pos_y][pos_x - 1] != '|')
    	 pos_x = pos_x - 1;
         break;
      case 38: if( gamemap[pos_y - 1][pos_x] != '|')
    	  pos_y = pos_y - 1;
         break;
      case 39: if( gamemap[pos_y][pos_x + 1] != '|')
    	 pos_x = pos_x + 1;
         break;
      case 40: if( gamemap[pos_y + 1][pos_x] != '|')
    	 pos_y = pos_y + 1;
         break;
      }
   }

   // the updatePosition algo allows us to stray off the map, so we put
   // a set of constraints to keep us on the map
   private void stayOnMap() {
      if (pos_x == GRID_SIZE)
         pos_x = GRID_SIZE - 1;
      if (pos_x < 0)
         pos_x = 0;
      if (pos_y == GRID_SIZE)
         pos_y = GRID_SIZE - 1;
      if (pos_y < 0)
         pos_y = 0;
   }

   // log the position to the console x,y
   private void logPosition() 
   {
      System.out.println("player position: "+ pos_x + "," + pos_y);
      System.out.println("monster position: "+ monster_x + "," + monster_y);
   }

   // this is the main event loop. we listen for keypresses. once a
   // keypress is released, we calculate the result and update state
   // if you want the game to be turn based this is the only event
   // listener you would need. If you want the game to be more real
   // time you could use a swing worker to dispatch events in the
   // background, but this can get complicated quickly

   // extend KeyAdapter as to not have to implement all the classes
   private class KeyListener extends KeyAdapter {

      public void keyReleased(KeyEvent evt) 
      {
         int keyCode = evt.getKeyCode();
         updatePosition(keyCode);
         stayOnMap();
         logPosition();
         updateMap(); 
      }
   }

   //create a timer and an update task to run in the event loop by implementing
   // the actionPerformed method for the swing timer interface

   private void updateMonsterPosition() 
   {
	  
      // randomly update the monster position
      Random rand = new Random(); 
      int r = rand.nextInt(2);
      //System.out.println(r);
      if (r == 0)
    	if(monster_x < pos_x && gamemap[monster_y][monster_x + 1] != '|') 
    	{
    		monster_x += 1;
    	}
      	else if(monster_x > pos_x && gamemap[monster_y][monster_x -1] != '|')
      	{
      		monster_x -= 1;
      	}
      if (r == 1)
      {
    	if (monster_y > pos_y && gamemap[monster_y - 1][monster_x] != '|') 
    	{
    		monster_y = monster_y - 1;
    	}
      	else if (monster_y < pos_y && gamemap[monster_y + 1][monster_x] != '|') 
      	{
      		monster_y = monster_y + 1;
      	}
    	
      }
      

      if (monster_x == GRID_SIZE)
         monster_x = GRID_SIZE - 1;
      if (monster_x < 0)
         monster_x = 0;
      if (monster_y == GRID_SIZE)
         monster_y = GRID_SIZE - 1;
      if (monster_y < 0)
         monster_y = 0;
      
   }

   // bad code for testing purposes
   private int player_health = 15;
   private int monster_health = 5;
   private int player_attack_min = 3;
   private int player_attack_max = 6;
   private int monster_attack_max = 3;
   private int monster_attack_min = 2;
   
   private void processBattle() {

      if( !detectCollision() ) return;

      Random rand = new Random(); 
      int r = rand.nextInt(player_attack_max  - player_attack_min);
      int r1 = rand.nextInt(monster_attack_max  - monster_attack_min);
      player_health -= (monster_attack_min + r);
      if(player_health <= 0)
         System.exit(0);
      if(monster_health > 0)
         monster_health -= (player_attack_min + r);
      return; 
   } 
   
   private boolean detectCollision() {
      if(pos_x == monster_x && pos_y == monster_y)
         return true;

      return false;
   }
   
   // This implements the timer updating the monster position asyncronously 
   public class TimerListener implements ActionListener 
   {
      public void actionPerformed(ActionEvent evt) 
      {
         updateMonsterPosition();
         updateMap();
         // System.out.println("monster at: " + monster_x + "," + monster_y);
      }
   }
   
   public static Game getInstance() 
   {
      return GameHolder.INSTANCE;
   }

   private static final class GameHolder 
   {
      static final Game INSTANCE = new Game();
   }
}

