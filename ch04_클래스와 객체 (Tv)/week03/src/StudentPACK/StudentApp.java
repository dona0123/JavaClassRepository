package StudentPACK;
import java.util.Scanner; 

public class StudentApp {
	public static void main(String[] a) {
		Student daro = new Student(); 

		daro.name = "다로교수"; 
		daro.id = 1234; 
		daro.getGrade(34); 
		
		Scanner s = new Scanner(System.in); 
		System.out.println("숫자입력: ");
		int n = s.nextInt();
		
		System.out.println("이름: " + daro.name); 
		System.out.println("학번: " + daro.id);
		System.out.println("성적: " + daro.grade);
	}
}



