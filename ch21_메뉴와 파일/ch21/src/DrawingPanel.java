
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JComponent;

public class DrawingPanel extends JComponent {

	public static final int CIRCLE = 0;
	public static final int SQUARE = 1;

	private int selectedShapeType = DrawingPanel.CIRCLE;
	private ArrayList<Shape> shapes;

	public DrawingPanel() { // 생성자
		shapes = new ArrayList<Shape>();

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Shape shape;

				if (selectedShapeType == DrawingPanel.CIRCLE) {
					shape = new Circle(e.getX(), e.getY(), 30);
				} else {
					shape = new Square(e.getX(), e.getY(), 60);
				}

				shapes.add(shape);
				repaint();
			}

		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// 저장된 모든 도형 그리기
		for (Shape shape : shapes) {
			shape.draw(g);
		}
	}

	public void setSelectedShapeType(int n) {
		selectedShapeType = n;
	}

	public void clear() {
		shapes.clear();
		repaint();
	}

	public void saveToFile(String filePath) {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
			objectOutputStream.writeObject(shapes); // shapes 리스트를 직렬화하여 저장
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadFromFile(String filePath) {
		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
			shapes = (ArrayList<Shape>) objectInputStream.readObject(); // 저장된 직렬화된 객체를 읽어옴
			repaint(); // 화면 다시 그리기
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
