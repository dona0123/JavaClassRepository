package ChildPACK;

public class ChildTest {
	Child child1, child2; 
	
	public void show() {
		System.out.print("child1: " );
		child1.showBead(); 
		System.out.print("child2: ");
		child2.showBead();  
	}
	
	public static void main(String[] a) {
		ChildTest sim = new ChildTest(); 
		
		sim.child1 = new Child(10); 
		sim.child2 = new Child(6); 
		
		System.out.println(">> before game");
		sim.show(); 
		System.out.println("\n");
		
		System.out.println(">> game1 start");
		sim.child1.gameWin(sim.child2, 5);
		sim.show(); 
		System.out.println("\n");
		
		System.out.println(">> game2 start");
		sim.child2.gameWin(sim.child1, 7);
		sim.show(); 
		
		
	}
}
