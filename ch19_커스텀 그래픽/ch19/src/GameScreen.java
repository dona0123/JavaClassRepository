import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

public class GameScreen extends JComponent {
	
	Unit player1, player2; 
	
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
						player1.isMovingRight = true; 
						
						break; 
						
					case KeyEvent.VK_LEFT:
						// p1 왼쪽 이동 
						player1.isMovingLeft = true; 
						
						break; 
						
					case KeyEvent.VK_D:
						// p2 오른쪽 이동 
						player2.isMovingRight = true; 
						
						break; 
						
					case KeyEvent.VK_A:
						// p2 왼쪽 이동 
						player2.isMovingLeft = true; 
						
						break; 
				}
				
				moveUnits(); 
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode(); 
				
				switch (key) {
					case KeyEvent.VK_RIGHT:
						// p1 오른쪽 이동 해제
						player1.isMovingRight = false; 
						
						break; 
						
					case KeyEvent.VK_LEFT:
						// p1 왼쪽 이동 해제
						player1.isMovingLeft = false; 
						
						break; 
						
					case KeyEvent.VK_D:
						// p2 오른쪽 이동 해제
						player2.isMovingRight = false; 
						
						break; 
						
					case KeyEvent.VK_A:
						// p2 왼쪽 이동 해제
						player2.isMovingLeft = false; 
						
						break; 
				}
				
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
	
	
}
