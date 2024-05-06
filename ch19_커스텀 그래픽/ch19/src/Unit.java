import java.awt.Color;
import java.awt.Graphics;

public class Unit {

	public static final int UNIT_SIZE = 50; 
	public static final int MOVE_DISTANCE = 10; 
	
	Color color; 
	int x, y; 
	boolean isMovingRight = false; 
	boolean isMovingLeft = false;

	
	public Unit(Color color, int x, int y) {
		this.color = color;
		this.x = x;
		this.y = y;
	} 
	
	public void draw(Graphics g) {
		g.setColor(color); 
		g.fillRect(x, y, UNIT_SIZE, UNIT_SIZE); 
	}
	
	public void move() {
		if (isMovingRight && x < 450) 
			x += MOVE_DISTANCE; 
		
		if (isMovingLeft && x > 0)
			x -= MOVE_DISTANCE; 
	}
	
	

}
