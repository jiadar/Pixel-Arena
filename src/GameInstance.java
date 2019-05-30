import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

class GameInstance {
    public static void main(String[] args) {
        Game g = Game.getInstance();
        g.open(0, 0, 300, 300);
    }
}
