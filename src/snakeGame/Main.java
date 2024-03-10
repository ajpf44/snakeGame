package snakeGame;

import javax.swing.JFrame;
import gameInterface.*;

public class Main {
	public static void main (String[] args) {
		GameWindow window = new GameWindow();
		JFrame frame = window.createWindow();
        GamePanel panel = new GamePanel();

        frame.add(panel);
        panel.addKeyListener(panel);
        
        panel.setFocusable(true);
        
        System.out.println("O jogo vai começar");
        for( int i = 0; i < 5; ++i) {
        	panel.createApple();
        }
	}
}