import hw.polygon.*;

public class CanvasApp {

	public static void main(String[] args) {

		Canvas c = new Canvas(3); 
		
		// 직사각형 그리기 
		Rectangle r = new Rectangle(4, 6, 8, 6); 
		c.draw(r);
		
		// 정사각형 그리기 
		Square s = new Square(1, 5, 10); 
		c.draw(s);
		
		// 삼각형 그리기 
		Triangle t = new Triangle(7, 8, 6, 8); 
		c.draw(t);
		
		// 출력하기 
		c.display();
	}

}
