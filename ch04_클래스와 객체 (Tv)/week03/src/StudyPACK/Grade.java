package StudyPACK;
import java.util.*; 

public class Grade {
	private int math;
	private int science;
	private int english; 
	
	public Grade(int m, int s, int e) {
		this.math = m; 
		this.science = s;
		this.english = e; 
	}
	
	public double average() {
		return (double)(this.math + this.science + this.english) / 3; 
	}
	
	// 1. 생성자 
	// 2. average()메소드 생성 

	
	
	// 과목의 점수를 입력받아 Grade 객체를 생성하고 성적 평균을 출력하는 main()과 실행 예시는 다음과 같다.

	public static void main(String[] args) {
		   // TODO Auto-generated method stub
		   Scanner sc = new Scanner(System.in);
		   
		   System.out.print("수학, 과학, 영어 순으로 3개의 정수 입력 >> ");
		   int math = sc.nextInt();
		   int science = sc.nextInt();
		   int english = sc.nextInt();
		   Grade me = new Grade(math, science, english);
		   System.out.println("평균은 "+me.average()); // average()는 평균을 계산하여 리턴
		   
		   
		   sc.close();
		}
		//수학, 과학, 영어 순으로 3개의 정수 입력 >> 60 70 55
		//결과: 61.666666
		//[Hint] Grade 클래스에 int 타입의 math, science, english 필드를 private로 선언하고, 생성자와 세 과목의 평균을 리턴하는 average() 메소드를 작성한다.
	
}
