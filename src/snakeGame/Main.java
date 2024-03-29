package snakeGame;

import javax.swing.JFrame;
import gameInterface.*;

public class Main {
	public static void main (String[] args) {
		GameWindow window = new GameWindow();
		JFrame frame = window.createWindow();
        GamePanel panel = new GamePanel();

        frame.add(panel);
        panel.setFocusable(true);
        
        System.out.println("O jogo vai começar");
        for( int i = 0; i < 5; ++i) {
        	panel.createApple();
        }
        
        frame.setVisible(true);
        
        String osName = System.getProperty("os.name");
        if(osName.equals("Linux")){
            panel.addKeyListener(panel); //ON LINUX THIS WILL WORK
        }else{
            frame.addKeyListener(panel);
        }
	}
}
