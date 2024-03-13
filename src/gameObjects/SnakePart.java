package gameObjects;

import java.awt.Color;
import java.awt.Graphics;

import gameInterface.GamePanel;

public abstract class SnakePart {
	protected int posX=0, posY= 0;
	protected Color color;
	
	public SnakePart(int initialX, int initialY, Color partColor) {
		posX = initialX;
		posY = initialY;
		color = partColor;
	}
	
	public void setPosition(int x, int y) {
		this.posX = x;
		this.posY = y;
	}
	
	public int getX() {
		return this.posX;
	}
	
	public int getY() {
        return this.posY;
    }
	
	public void moveX(int sinal) {
		int newPosX = posX + (sinal * Movement.speed);
		
		if( newPosX >= 0 && newPosX <= 800-70) {
			posX = newPosX;
		}else {
			GamePanel.gameStatus = "Game Over";
		}
	}
	public void moveY(int sinal) {
		int newPosY = posY + (sinal * Movement.speed);
		
		if( newPosY <= 800-70 && newPosY >= 0) {
			posY = newPosY;
		}else {
			GamePanel.gameStatus = "Game Over";
		}
		
	}
	
	public void paintComponent(Graphics g){	
	    g.setColor(this.color); // Set the color to red
	    g.fillRect(posX, posY, 50, 50);
	}
}
