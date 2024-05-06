import java.awt.*;

import javax.swing.*;

public class RegMember {

	JFrame frame;

	public RegMember() {

		frame = new JFrame("사원 등록_20200551");

		// GUI 배치
		JPanel p = buildGUI();
		frame.add(p); 

		// 프레임 설정
		frame.setSize(350, 420);
		frame.setLocation(600, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	private JPanel buildGUI() { // GUI 배치
		
		JPanel p = new JPanel(); 
		p.setLayout(new BorderLayout());
		
		p.add(buildTopPanel(), BorderLayout.NORTH);
		p.add(bulidBottomPanel(), BorderLayout.CENTER); 
		
		return p; 
	}

	private JPanel buildTopPanel() { // 상단 패널 배치
		
		JPanel p = new JPanel(); 
		p.setLayout(new GridLayout(5,1)); 
		
		p.add(createNamePanel()); 
		p.add(createNumberPanel()); 
		p.add(createAddressPanel()); 
		p.add(createDepartmentPanel());  
		p.add(createHobbyPanel());  
		
		return p; 
	}
	
	private JPanel bulidBottomPanel() { // 하단 패널 배치
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		
		p.add(createIntroPanel(), BorderLayout.CENTER); 
		p.add(createButtonPanel(), BorderLayout.SOUTH); 
		
		return p; 
	}

	public JPanel createNamePanel() { // 이름 패널 제작

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));

		// 성명, 성별 레이아웃

		JLabel l_name = new JLabel("성               명");
		JTextField t_name = new JTextField(8);
		JLabel l_gender = new JLabel("성     별");
		JTextField t_gender = new JTextField(3);

		p.add(l_name);
		p.add(t_name);
		p.add(l_gender);
		p.add(t_gender);

		return p;
	}

	public JPanel createNumberPanel() { // 주민번호 패널 제작

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));

		JLabel l_num = new JLabel("주민등록번호");
		JTextField t_num1 = new JTextField(6);
		JLabel l_slash = new JLabel("-");
		JTextField t_num2 = new JTextField(7);

		p.add(l_num);
		p.add(t_num1);
		p.add(l_slash);
		p.add(t_num2);

		return p;
	}

	public JPanel createAddressPanel() { // 주소 패널 제작

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));

		JLabel l_ad = new JLabel("주               소");
		JTextField t_ad = new JTextField(22);

		p.add(l_ad);
		p.add(t_ad);

		return p;
	}

	public JPanel createDepartmentPanel() { // 부서명 패널 제작

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));

		JLabel l_part = new JLabel("부      서      명");
		JTextField t_part = new JTextField(8);

		p.add(l_part);
		p.add(t_part);

		return p;
	}
	
	public JPanel createHobbyPanel() { // 취미 패널 제작

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));

		JLabel l_hobby = new JLabel("취               미");
		JTextField t_hobby = new JTextField(22);

		p.add(l_hobby);
		p.add(t_hobby);

		return p;
	}

	public JPanel createIntroPanel() { // 자기소개 패널 제작

		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());

		JLabel l_intro = new JLabel("  자   기  소  개");
		JTextArea a_intro = new JTextArea(9, 22);

		p.add(l_intro, BorderLayout.NORTH);
		p.add(a_intro, BorderLayout.CENTER);

		return p;
	}

	public JPanel createButtonPanel() { // 버튼 패널 제작

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton b_save = new JButton("저장");
		JButton b_exit = new JButton("종료");

		p.add(b_save);
		p.add(b_exit);

		return p;
	}

	public static void main(String[] args) {
		new RegMember(); 
	}
}
