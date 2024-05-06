package hw.polygon;

// 삼각형 클래스 
public class Triangle extends Polygon {

	// >> 생성자
	public Triangle(int x, int y, int w, int h) {
		super("Triangle", x, y, w, h);
	}

	// >> 메서드
	// 삼각형의 넓이 구하기
	@Override
	public double getArea() {
		return (w * h) / 2;
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

		if (obj == null || !(obj instanceof Triangle)) {
			return false;
		}

		Triangle other = (Triangle) obj;

		return x == other.x && y == other.y && w == other.w && h == other.h;
	}

}
