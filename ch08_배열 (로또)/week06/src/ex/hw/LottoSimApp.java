package ex.hw;

import java.util.Scanner;
import ex.lotto.LottoCard;

public class LottoSimApp {

	public static void main(String[] args) {
		
		// 1차 구매 
		System.out.println(">> First purchase");
		LottoCard lottos1 = new LottoCard(2); 
		Scanner s = new Scanner(System.in); 
		int[] n = new int[6]; 
	
		// 1차: 1번째 로또 입력받기 
		System.out.println("Enter six numbers: ");
		for (int i=0; i<n.length; i++) {
			n[i] = s.nextInt();
		}
		lottos1.manual(1, n); 
		
		// 1차: 2번째 로또 입력받기 
		System.out.println("Enter six numbers: ");
		for (int i=0; i<n.length; i++) {
			n[i] = s.nextInt();
		}
		lottos1.manual(2, n); 
		
		s.close();
		lottos1.show();
		System.out.println();
		
		
		// 2차 구매 
		System.out.println(">> Second purchase");
		LottoCard lottos2 = new LottoCard(5); 
		
		lottos2.auto(1);
		lottos2.auto(2);
		lottos2.auto(3);
		lottos2.auto(4);
		lottos2.auto(5);
		
		lottos2.show();
		
	}

}
