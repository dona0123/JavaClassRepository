package RectanglePACK;

public class Point {
	private int x = 0; 
	private int y = 0; 
	
	public Point(int x, int y) {
		this.x = x; 
		this.y = y; 
	}
	
	int getX() {
		return x;
	}
	
	int getY() {
		return y;
	}
	
	void show() {
		System.out.println("(" + x + "," + y + ")");
	}
}
