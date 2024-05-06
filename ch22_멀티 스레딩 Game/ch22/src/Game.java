import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame {

	private GameScreen gameScreen;

	public Game() {
		super("2인용 게임");

		buildGUI();

		this.setSize(500, 500);
		this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	private void buildGUI() {
		gameScreen = new GameScreen();
		this.add(gameScreen);
		this.add(createButtonPanel(), BorderLayout.SOUTH);
	}

	private JPanel createButtonPanel() {
		JPanel p = new JPanel(new GridLayout(1,0));

		JButton bs = new JButton("시작");
		JButton be = new JButton("끝");

		p.add(bs);
		p.add(be);

		ActionListener hander = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == bs) { // 시작
					gameScreen.start();
				} else if (src == be) { // 끝
					gameScreen.end();
				}
			}

		};
		
		bs.addActionListener(hander);
		be.addActionListener(hander);
		

	

		return p;
	}

	public static void main(String[] args) {
		new Game();
	}

}
