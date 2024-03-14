package gameObjects;

import java.util.ArrayList;

public class Movement {
	protected static int speed = 50;
	
	public static Apple touchingApple(SnakeHead sHead, ArrayList<Apple> aList) {
		Apple touchedApple = null;
		for (Apple apple :aList) {
			if (apple.getX() == sHead.getX() && apple.getY() == sHead.getY()) {
                touchedApple = apple;
            }
		}
		
		return touchedApple;
	}
	
	public static boolean isTouchingSnake(SnakeHead sHead, ArrayList<SnakeBody> bList) {
		boolean isTouching = false;
        for (SnakeBody body :bList) {
            if (body.getX() == sHead.getX() && body.getY() == sHead.getY()) {
                isTouching = true;
            }
        }
        
        return isTouching;
	}
}
