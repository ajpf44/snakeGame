package gameInterface;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

import javax.swing.JPanel;

import gameObjects.Apple;
import gameObjects.SnakeHead;
import gameObjects.Movement;


public class GamePanel extends JPanel implements KeyListener {
	
	SnakeHead snakeHead = new SnakeHead(0,0,Color.red);
	ArrayList<Apple> appleList = new ArrayList<Apple>();
	
	public void createApple() {
		int x = (int) (Math.random() * 15);
		int y = (int) (Math.random() * 15);
		
		appleList.add(new Apple(x*50,y*50));
	}
	
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    snakeHead.paintComponent(g);
	    
	    for(Apple a : appleList) {
            a.paintComponent(g);
        }
	     // Draw a rectangle with specific coordinates and dimensions
	}
    
	//Talvez passar essa função para o Movement
    public void moveFromKey() {
    	
    	if (keyToMove.getKeyCode() == KeyEvent.VK_RIGHT) {
            // Move the rectangle right
            snakeHead.moveX(1);
            this.repaint();
        } else if (keyToMove.getKeyCode() == KeyEvent.VK_LEFT) {
            // Move the rectangle left
        	snakeHead.moveX(-1);
            this.repaint();
        }
    	
    	if (keyToMove.getKeyCode() == KeyEvent.VK_UP) {
    			// Move the rectangle up
    		snakeHead.moveY(-1);
            this.repaint();
        } else if (keyToMove.getKeyCode() == KeyEvent.VK_DOWN) {
            // Move the rectangle down
        	snakeHead.moveY(1);
            this.repaint();
    	}
    }
    
       
    @Override
    public void keyReleased(KeyEvent e) {
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	
	//Uma classe chamada Movement
	boolean isTheFirstMovement = true;
    KeyEvent keyToMove;
    int movimentSpeedMilli = 500;
	@Override
	public void keyPressed(KeyEvent e) {
		keyToMove = e;
		if( isTheFirstMovement) {
			Timer t = new Timer();
	    	t.scheduleAtFixedRate(new TimerTask(){
	    	    @Override
	    	    public void run(){
	    	    	moveFromKey();
	    	    	Movement.isTouchingApple(snakeHead, appleList);
	    	    }
	    	},0,movimentSpeedMilli);
		}  
		isTheFirstMovement = false;
	}
}
