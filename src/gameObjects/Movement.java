package gameObjects;

import java.util.ArrayList;

public class Movement {
	protected static int speed = 50;
	
	public static void isTouchingApple(SnakeHead sHead, ArrayList<Apple> aList) {
		Apple touchedApple = null;
		for (Apple apple :aList) {
			if (apple.getX() == sHead.getX() && apple.getY() == sHead.getY()) {
                touchedApple = apple;
            }
		}
		
		if (touchedApple!= null) {
            //snakeHead.grow();
            aList.remove(touchedApple);
        }
	}
}
