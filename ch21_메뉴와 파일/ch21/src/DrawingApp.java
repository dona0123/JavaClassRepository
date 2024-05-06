
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DrawingApp extends JFrame {

	DrawingPanel drawingPanel = new DrawingPanel();

	public DrawingApp() { // 생성자
		super("Drawing Application");

		buildGUI();
		createMenuBar();

		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				int rval = JOptionPane.showConfirmDialog(DrawingApp.this, "종료 하시겠습니까?", "확인",
						JOptionPane.YES_NO_OPTION);

				if (rval == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

				JOptionPane.showMessageDialog(DrawingApp.this, "종료가 취소되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);

			}

		});

		this.setVisible(true);
	}

	private void createMenuBar() { // 메뉴바 만들기

		JMenuBar menuBar = new JMenuBar();

		menuBar.add(createFileMenu());
		menuBar.add(createShapeMenu());

		this.setJMenuBar(menuBar);

	}

	private JMenu createShapeMenu() { // 모양 메뉴 만들기

		JMenu shapeMenu = new JMenu("Shape");

		JMenuItem circleItem = new JMenuItem("Circle");
		JMenuItem squareItem = new JMenuItem("Square");

		// "Circle" 메뉴 아이템에 대한 ActionListener
		circleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawingPanel.setSelectedShapeType(DrawingPanel.CIRCLE);
			}

		});

		// "Square" 메뉴 아이템에 대한 ActionListener
		squareItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawingPanel.setSelectedShapeType(DrawingPanel.SQUARE);

			}

		});

		shapeMenu.add(circleItem);
		shapeMenu.add(squareItem);

		return shapeMenu;
	}

	private JMenu createFileMenu() { // 파일 메뉴 만들기
		JMenu fileMenu = new JMenu("File");

		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem loadMenuItem = new JMenuItem("Load");
		JMenuItem saveMenuItem = new JMenuItem("Save");

		JFileChooser fileChooser = new JFileChooser();

		// 파일 필터 적용
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");

		fileChooser.setFileFilter(filter);

		// "New" 메뉴 아이템에 대한 ActionListener
		newMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawingPanel.clear();
			}
		});

		// "Load" 메뉴 아이템에 대한 ActionListener
		loadMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal = fileChooser.showOpenDialog(DrawingApp.this); // DrawingApp.this에 불러오기 대화상자 표시
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					// 사용자가 파일을 선택했을 때의 작업 수행 (파일 경로명 받아오기)
					String filePath = fileChooser.getSelectedFile().getPath();
					drawingPanel.loadFromFile(filePath);
				}
			}
		});

		// "Save" 메뉴 아이템에 대한 ActionListener
		saveMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal = fileChooser.showSaveDialog(DrawingApp.this); // DrawingApp.this에 저장 대화상자 표시
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					// 사용자가 저장을 선택했을 때의 작업 수행 (파일 경로명 받아오기)
					String filePath = fileChooser.getSelectedFile().getPath();
					drawingPanel.saveToFile(filePath);
				}
			}
		});

		fileMenu.add(newMenuItem);
		fileMenu.add(loadMenuItem);
		fileMenu.add(saveMenuItem);

		return fileMenu;
	}

	private void buildGUI() { // GUI 생성하기
		this.add(drawingPanel);
	}

	public static void main(String[] args) {

		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);

		new DrawingApp();
	}

}
