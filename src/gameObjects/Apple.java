package gameObjects;

import java.awt.Color;
import java.awt.Graphics;

public class Apple {
	private int x, y;
	
	Color color= Color.red;
	public Apple(int x, int y) {
        this.x = x;
        this.y = y;
    }
	
	public int getX() {
        return x;
    }
	
	public int getY() {
		return y;
	}
	
	public void paintComponent(Graphics g){	
	    g.setColor(this.color); // Set the color to red
	    g.fillRect(x, y, 50, 50);
	}
}
