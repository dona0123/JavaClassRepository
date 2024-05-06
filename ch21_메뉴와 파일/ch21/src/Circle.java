
import java.awt.Graphics;

public class Circle extends Shape {

	private int radius;

	public Circle(int x, int y, int r) {
		super(x, y);
		this.radius = r;
	}

	public int getRadius() {
		return this.radius;
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(this.x, this.y, this.radius, this.radius);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
