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
import gameObjects.SnakeBody;
import gameObjects.Movement;


public class GamePanel extends JPanel implements KeyListener{
	
	SnakeHead snakeHead = new SnakeHead(0,0,Color.red);
	
	ArrayList<Apple> appleList = new ArrayList<Apple>();
	ArrayList<SnakeBody> snakeBodyList = new ArrayList<SnakeBody>();
	
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
	    for(SnakeBody sb : snakeBodyList) {
	    	sb.paintComponent(g);
	    }
	     // Draw a rectangle with specific coordinates and dimensions
	}
    
	//Talvez passar essa função para o Movement
    public void moveFromKey() {
    	int headPosX = snakeHead.getX();
    	int headPosY = snakeHead.getY();
    	
    	for(int i = snakeBodyList.size()-1; i  >= 0; --i) {
    		SnakeBody sb = snakeBodyList.get(i);
    		if(i == 0) {
    			sb.setPosition( headPosX, headPosY);
    		}else {
    			SnakeBody sbBefore = snakeBodyList.get(i-1);
    			sb.setPosition(sbBefore.getX(), sbBefore.getY());
    		}
    	}
    	
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
	
	
	//
	boolean isTheFirstMovement = true;
    KeyEvent keyToMove;
    int incrementX;
    int incrementY;
    int movimentSpeedMilli = 300;
	@Override
	public void keyPressed(KeyEvent e) {
		keyToMove = e;
		if( isTheFirstMovement) {
			Timer t = new Timer();
	    	t.scheduleAtFixedRate(new TimerTask(){
	    	    @Override
	    	    public void run(){
	    	    	moveFromKey();
	    	    	Apple touchedApple = Movement.touchingApple(snakeHead, appleList);
	    	    	if(touchedApple != null) {
	    	    		appleList.remove(touchedApple);
	    	    		Color partColor = Color.DARK_GRAY;
	    	    		if(appleList.size() % 2 ==0) {
	    	    			partColor = Color.blue;
	    	    		}
	    	    		snakeBodyList.add(new SnakeBody(
	    	    				touchedApple.getX() + snakeBodyList.size()*incrementX,
	    	    				touchedApple.getY() + snakeBodyList.size()*incrementY,
	    	    				partColor)
	    	    		);
	    	    	}
	    	    	
	    	    	if(appleList.size() == 0) {
	    	    		for(int i = 0; i < 5; i++) {
	    	    			createApple();
	    	    		}
	    	    	}
	    	    }
	    	},0,movimentSpeedMilli);
		}  
		isTheFirstMovement = false;
	}
}
