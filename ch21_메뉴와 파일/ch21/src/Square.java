
import java.awt.Graphics;

public class Square extends Shape {

	private int side;

	public Square(int x, int y, int s) {
		super(x, y);
		this.side = s;
	}

	public int getSide() {
		return this.side;
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(this.x, this.y, this.side, this.side);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
