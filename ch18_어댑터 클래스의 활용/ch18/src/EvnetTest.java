import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel; 

public class EvnetTest extends JFrame {

	JLabel unit;
	
	public EvnetTest() {
		super("이벤트 테스트");
		
		buildGUI(); 
		
		this.setSize(500, 500);
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		
		this.addWindowListener(wHandler);
		
	}
	
	WindowListener wHandler = new WindowAdapter() {

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("thx");
			System.exit(0); 
		}
		
		
	};
	
	// WindowListener wHandler = new WindowListener
			
			
	
	public void buildGUI() {
		this.add(creatDisplayPanel()); 
	}
	
	private JPanel creatDisplayPanel() {
		JPanel p = new JPanel(null);
		
		unit = new JLabel("START");
		unit.setBounds(100, 200, 50, 20);
		
		p.add(unit);
		p.setFocusable(true);
		
		p.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int evnet = e.getKeyCode(); 
				if (KeyEvent.VK_RIGHT == evnet) {
					unit.setLocation(500,200); 
				} else {
					unit.setLocation(200,200); 
				}
				
			}
			
		});
		
//		p.addMouseListener(new MouseAdapter() {
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				
//				unit.setLocation(e.getX(), e.getY());
//			}
//			
//		});
		
		p.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				unit.setText(e.getX() + ", " + e.getY());
			}
			
		});
		
		return p; 
	}
	
	public static void main(String[] args) {
		new EvnetTest(); 
	}
}
