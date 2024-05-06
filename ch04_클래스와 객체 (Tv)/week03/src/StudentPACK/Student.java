package StudentPACK;

public class Student {
	
	static final int YEAR = 2023; 
	
	String name; 
	int id; 
	char grade; 
	
	void getName(String n) {
		name = n; 
	}
	
	void getId(int i) {
		id = i; 
	}
	
	char getGrade(int s) {
		if (s>90) {
			grade = 'A'; 
		} else if (s>80) {
			grade = 'B'; 
		}else if (s>70) {
			grade = 'C'; 
		}else if (s>60) {
			grade = 'D'; 
		}else {
			grade = 'F'; 
		}
		return grade; 
		
	}
}
