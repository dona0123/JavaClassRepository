package RectanglePACK;

public class Rectangle {
	// 두 꼭지점 
	Point lt; 
	Point rb; 
	
	// 생성자 
	public Rectangle(int x1, int y1, int x2, int y2){
		lt = new Point(x1, y1);
		rb = new Point(x2, y2);
	}
	
	public Rectangle(Point left, Point right) {
		lt = new Point(left.getX(), left.getY());
		rb = new Point(right.getX(), right.getY());
	}
	
	// 메서드 
	int getWidth() {
		return this.rb.getX() - this.lt.getX();
	}
	
	int getHeight() {
		return this.rb.getY() - this.lt.getY(); 
	}
	
	int getPerimeter() {
		return 2 * (this.getHeight()+this.getWidth()); 
	}
	
	int getArea() {
		return this.getWidth() * this.getHeight(); 
	}
	
	void show() {
		System.out.print("[ Rectangle " + this.getWidth() + "x" + this.getHeight() + ":");
		System.out.println(" (" + this.lt.getX() + "," + this.lt.getY() + "), (" + this.rb.getX() + "," + this.rb.getY() + ") ]");
	}
	
}
