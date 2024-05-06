package hw.polygon;

// 정사각형 클래스
public class Square extends Rectangle {

	// >> 생성자
	public Square(int x, int y, int w) {
		super(x, y, w, w);
		this.type = "Square";
	}

}
