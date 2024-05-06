import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class RegMember3 {

	JFrame frame;
	JTextArea t_intro;
	JTextField t_name;
	JTextField t_num1;
	JTextField t_num2;
	JTextField t_ad;
	JComboBox<String> c_part;
	JCheckBox[] c_hobby;
	int hobby_i;

	public RegMember3() {

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
		p.setLayout(new GridLayout(5, 1));

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

		return p;
	}

	public JPanel createNamePanel() { // 성명, 성별 패널 제작

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));

		// 성명 레이아웃

		JLabel l_name = new JLabel("성                명");
		t_name = new JTextField(8);
		t_name.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 성명 출력
				t_intro.append("성명: " + t_name.getText() + "\n");
				t_name.setText("");
			}
		});

		// 성별 레이아웃
		// 라디오버튼 적용
		JLabel l_gender = new JLabel("성     별");

		ButtonGroup b_gender = new ButtonGroup();

		JRadioButton mb_gender = new JRadioButton("남");
		JRadioButton fb_gender = new JRadioButton("여");

		// 성별 출력
		mb_gender.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (mb_gender.isSelected()) {
					t_intro.append("성별: " + mb_gender.getText());
					t_intro.append("\n");
				}

			}
		});

		fb_gender.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (fb_gender.isSelected()) {
					t_intro.append("성별: " + fb_gender.getText());
					t_intro.append("\n");
				}

			}
		});

		b_gender.add(mb_gender);
		b_gender.add(fb_gender);

		p.add(l_name);
		p.add(t_name);
		p.add(l_gender);
		p.add(mb_gender);
		p.add(fb_gender);

		return p;
	}

	public JPanel createNumberPanel() { // 주민번호 패널 제작

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));

		JLabel l_num = new JLabel("주민등록번호");
		t_num1 = new JTextField(6);
		JLabel l_slash = new JLabel("-");
		t_num2 = new JTextField(7);

		// 주민번호 출력
		t_num2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t_intro.append("주민등록번호: " + t_num1.getText() + "-" + t_num2.getText() + "\n");
				t_num1.setText("");
				t_num2.setText("");
			}

		});

		p.add(l_num);
		p.add(t_num1);
		p.add(l_slash);
		p.add(t_num2);

		return p;
	}

	public JPanel createAddressPanel() { // 주소 패널 제작

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));

		JLabel l_ad = new JLabel("주                소");
		t_ad = new JTextField(22);

		// 주소 출력
		t_ad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t_intro.append("주소: " + t_ad.getText() + "\n");
				t_ad.setText("");
			}

		});

		p.add(l_ad);
		p.add(t_ad);

		return p;
	}

	public JPanel createDepartmentPanel() { // 부서명 패널 제작

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));

		// 콤보박스 적용
		JLabel l_part = new JLabel("부      서      명");
		String[] arr = { "충무부", "회계부", "기획부", "인사부" };

		c_part = new JComboBox<>(arr);
		
		// 부서명 출력
		c_part.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t_intro.append("부서명: " + c_part.getSelectedItem() + "\n");
			}

		});

		p.add(l_part);
		p.add(c_part);

		return p;
	}

	public JPanel createHobbyPanel() { // 취미 패널 제작
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));

		// 체크박스 적용
		JLabel l_hobby = new JLabel("취                미");
		p.add(l_hobby);

		String[] hobbylist = { "영화", "음악감상", "사진", "운동" };
		c_hobby = new JCheckBox[hobbylist.length];

		for (int i = 0; i < hobbylist.length; i++) {
			c_hobby[i] = new JCheckBox(hobbylist[i]);
			p.add(c_hobby[i]);
			addHobbyItemListener(c_hobby[i]);
		}

		return p;
	}

	// 취미 출력 
	private void addHobbyItemListener(JCheckBox checkBox) {
		checkBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (checkBox.isSelected()) {
					t_intro.append("취미: " + checkBox.getText() + " ");
					t_intro.append("\n");
				}
			}
		});
	}

	public JPanel createIntroPanel() { // 자기소개 패널 제작

		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());

		JLabel l_intro = new JLabel("  자   기  소  개");
		t_intro = new JTextArea(9, 22);
		JScrollPane scrollPane = new JScrollPane(t_intro);

		p.add(l_intro, BorderLayout.NORTH);
		p.add(scrollPane, BorderLayout.CENTER);

		return p;
	}

	public static void main(String[] args) {
		new RegMember3();
	}
}
