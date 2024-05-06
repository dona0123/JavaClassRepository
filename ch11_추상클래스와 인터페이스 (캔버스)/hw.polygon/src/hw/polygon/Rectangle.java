package hw.polygon;

// 직사각형 클래스 
public class Rectangle extends Polygon {

	// >> 생성자
	public Rectangle(int x, int y, int w, int h) {
		super("Rectangle", x, y, w, h);
	}

	// >> 메서드
	// 직사각형의 넓이 구하기
	@Override
	public double getArea() {
		return w * h;
	}

	// 정보 출력하기
	@Override
	public void show() {
		super.show();
		System.out.println("Area: " + getArea());
	}

	// 객체 비교하기
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || !(obj instanceof Rectangle)) {
			return false;
		}

		Rectangle other = (Rectangle) obj;

		return x == other.x && y == other.y && w == other.w && h == other.h;
	}

	// 정사각형 여부 확인
	public boolean isSquare() {
		if (w == h) {
			return true;
		}
		return false;
	}
}
