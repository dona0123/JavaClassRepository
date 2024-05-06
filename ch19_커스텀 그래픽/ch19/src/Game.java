import javax.swing.JFrame;

public class Game extends JFrame {
	
	public Game() {
		super("2인용 게임"); 
		
		buildGUI(); 
		
		this.setSize(500,500);
		this.setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	private void buildGUI() {
		GameScreen gameScreen = new GameScreen(); 
		this.add(gameScreen); 
	}

	public static void main(String[] args) {
		new Game(); 
	}

}
