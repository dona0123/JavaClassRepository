import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

public class GameScreen extends JComponent {

	public static final int SCREEN_WIDTH = 500;
	public static final int SCREEN_HIGHT = 500;

	Unit player1, player2;

	Thread moveThread;

	public GameScreen() {
//		super(); 
		player1 = new Unit(Color.BLUE, 400, 200);
		player2 = new Unit(Color.red, 30, 200);

		this.setFocusable(true);
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();

				switch (key) {
				case KeyEvent.VK_RIGHT:
					// p1 오른쪽 이동
					player1.startMoving(Unit.RIGHT);

					break;

				case KeyEvent.VK_LEFT:
					// p1 왼쪽 이동
					player1.startMoving(Unit.LEFT);
					break;

				case KeyEvent.VK_UP:
					// p1 위 이동
					player1.startMoving(Unit.UP);
					break;

				case KeyEvent.VK_DOWN:
					// p1 아래 이동
					player1.startMoving(Unit.DOWN);
					break;

				case KeyEvent.VK_A:
					// p2 왼쪽 이동
					player2.startMoving(Unit.LEFT);
					break;
					
				case KeyEvent.VK_F:
					// p2 오른쪽 이동
					player2.startMoving(Unit.RIGHT);
					break;
					
				case KeyEvent.VK_S:
					// p2 위 이동
					player2.startMoving(Unit.UP);
					break;
					
				case KeyEvent.VK_D:
					// p2 아래 이동
					player2.startMoving(Unit.DOWN);
					break;
				}

//				moveUnits(); 
			}

		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

//		g.setColor(Color.BLUE); 
//		g.fillRect(400, 200, 50, 50);
		player1.draw(g);

//		g.setColor(Color.red);
//		g.fillRect(30, 200, 50, 50);
		player2.draw(g);
	}

	public void moveUnits() {
		player1.move();
		player2.move();

		this.repaint();
	}

	public void start() {
//		while (true) {
//			moveUnits(); 
//		} 

//		Runnable r = new Runnable() {
//
//			@Override
//			public void run() {
//				
//			}
//			
//		}

		moveThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (moveThread == Thread.currentThread()) {
					moveUnits();

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		});

		moveThread.start();
		this.requestFocus();
	}

	public void end() {
		moveThread = null;

	}

}
