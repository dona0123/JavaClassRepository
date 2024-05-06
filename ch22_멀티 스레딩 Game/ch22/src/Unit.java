import java.awt.Color;
import java.awt.Graphics;

public class Unit {


	
	public static final int UNIT_SIZE = 50; 
	public static final int MOVE_DISTANCE = 10; 
	
	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	public static final int UP = 3;
	public static final int DOWN = 4;
	
	
	Color color; 
	int x, y; 
//	boolean isMovingRight = false; 
//	boolean isMovingLeft = false;
	
	int xDirection; // -1, 0, 1 (좌로, 정지, 아래) 
	int yDirection; // -1, 0, 1 (위로, 정지, 아래) 

	
	public Unit(Color color, int x, int y) {
		this.color = color;
		this.x = x;
		this.y = y;
		
		xDirection = 0; 
		yDirection = 0; 
	} 
	
	public void startMoving(int direction) {
		
		stopMoving(); 
		
		switch (direction){
		case LEFT: 
			xDirection = -1; 
			break; 
			
		case RIGHT: 
			xDirection = 1; 
			break; 
		
		case UP: 
			yDirection = -1; 
			break; 
			
		case DOWN: 
			yDirection = 1; 
			break; 
			
		}
	}
	
	public void stopMoving() {
		xDirection = 0; 
		yDirection = 0; 
	}
	
	public void draw(Graphics g) {
		g.setColor(color); 
		g.fillRect(x, y, UNIT_SIZE, UNIT_SIZE); 
	}
	
	public void move() {
//		if (isMovingRight && x < 450) 
//			x += MOVE_DISTANCE; 
//		
//		if (isMovingLeft && x > 0)
//			x -= MOVE_DISTANCE; 
		
		x += xDirection * MOVE_DISTANCE; 
		y += yDirection * MOVE_DISTANCE; 
		
		if (x<=0 || x + UNIT_SIZE >= GameScreen.SCREEN_WIDTH) {
			xDirection = -xDirection; 
		} 
		
		if (y<=0 || y + UNIT_SIZE >= GameScreen.SCREEN_HIGHT) {
			yDirection = -yDirection; 
		}
	}
	
	

}
