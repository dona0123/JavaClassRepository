package ChildPACK;

public class Child {
	// 필드 
	private int beadnum; 
	
	// 생성자 
	public Child(int beadnum) {
		this.beadnum = beadnum;
	}
	
	// 메서드 
	// 이겼을 경우 
	public void gameWin(Child child, int beadnum) {
		this.beadnum += child.gameLose(beadnum); 
	}
	
	// 졌을 경우 
	public int gameLose(int beadnum) {
		int temp; 
		
		if (this.beadnum <= beadnum) { 
			temp = this.beadnum; 
			this.beadnum = 0; 
			return temp; 
		} else {
			this.beadnum -= beadnum; 
			return beadnum; 
		}
	}
	
	// 구슬 개수 출력 
	public void showBead() {
		System.out.println("beadnum is " + this.beadnum);
	} 
}

	
