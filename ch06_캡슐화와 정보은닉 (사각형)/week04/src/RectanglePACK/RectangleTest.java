package RectanglePACK;

public class RectangleTest {
	
	static void show(Rectangle r) {
		r.show();
		System.out.print("Area: " + r.getArea());
		System.out.print(", ");
		System.out.println("Perimeter: " + r.getPerimeter());
	}
	
	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle(1, 0, 10, 5); 
		RectangleTest.show(rect1); 
		
		System.out.println();
		
		Rectangle rect2 = new Rectangle(new Point(0,0), new Point(5,10));
		RectangleTest.show(rect2);
		
	}
}
