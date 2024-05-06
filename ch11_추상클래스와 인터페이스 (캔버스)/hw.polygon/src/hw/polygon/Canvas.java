package hw.polygon;

public class Canvas {
	// >> 멤버 변수
	// 다각형을 저장할 배열
	private Polygon[] Poly;

	// 배열의 할당크기, 순번
	private int size;
	private int num = 0;

	// >> 생성자
	public Canvas(int s) {
		size = s;
		Poly = new Polygon[size];
	}

	// 도형 그리기
	public void draw(Polygon p) {
		if (size <= num) {
			System.out.println("Canvas is full...\n");
		} else {
			Poly[num++] = p;
		}
	}

	// 그려진 도형들의 정보를 문자열로 표시
	public void display() {
		for (Polygon p : Poly) {
			p.show();
			
			if (p instanceof Rectangle) {
				if (((Rectangle) p).isSquare()) {
					System.out.println("Is Square");
				} else {
					System.out.println("Is Not Square");
				}
			}
			System.out.println("\n");
		}
	}
}
