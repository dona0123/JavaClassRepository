// 20200551 편도나 
// 04. 클래스와 객체 실습 - 실습과제 2: TV
// TV 객체 생성 

package TvPACK;

public class TVUser {
	public static void main(String a[]) {
		int i; 
		TV mytv = new TV(); 
		
		
		// 전원 OFF일 시 작동하지 않음 
		mytv.channelUp();
		mytv.channelDown();
		mytv.volumeUp();
		mytv.volumeDown();
		
		
		// 전원 ON
		System.out.println("\n======status ON======");
		mytv.pushPower(); 
		
		
		// 채널 올리기 
		System.out.println("\n======channel Up======");
		for (i=0; i<5; i++) {
			mytv.channelUp();
		}
		

		// 채널 내리기 
		System.out.println("\n======channel Down======");
		for (i=0; i<6; i++) {
			mytv.channelDown();
		}
		
		
		// 볼륨 높이기 
		System.out.println("\n======volume Up======");
		for (i=0; i<6; i++) {
			mytv.volumeUp();
		}
		
		
		// 볼륨 내리기 
		System.out.println("\n======volumeDown======");
		for (i=0; i<11; i++) {
			mytv.volumeDown();
		}
		
	}
	
}
