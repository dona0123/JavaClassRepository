package hw.polygon;

public abstract class Polygon {
	// >> 멤버 변수
	// 위치
	int x, y;

	// 크기
	int w, h;

	// 도형의 종류 
	String type;

	// >> 메서드
	// 도형의 기본정보 표시
	public void show() {
		System.out.print("[" + type + "] : ");
		System.out.println("(" + x + "," + y + ")");
		System.out.println("Width, Height : " + w + ", " + h);
	}

	// 도형의 넓이 계산
	public abstract double getArea();

	// > 생성자
	public Polygon(String name, int x, int y, int w, int h) {
		this.type = name;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
}
