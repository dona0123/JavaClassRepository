// 20200551 편도나 
// 04. 클래스와 객체 실습 - 실습과제 2: TV
// TV 클래스 정의 

package TvPACK;

public class TV {
	// 채널과 볼륨의 최댓값 기호상수 
	static final int MAX_CHANNEL = 5; 
	static final int MAX_VOLUME = 10; 
	
	// 상태, 채널, 볼륨 속성 
	boolean status = false; 
	int channel = 1; 
	int volume = 5; 
	
	// 메소드 
	void pushPower() {
		if (status == true) {
			status = false; 
			System.out.println("TV OFF");
		} else {
			status = true; 
			System.out.println("TV ON");
		}
	}
	
	void channelUp() {
		if (status == true) {
			if (channel < MAX_CHANNEL) {
				channel++; 
			} else {
				channel = 1; 
			}
			System.out.println("channel: " + channel);
		} 
		
	}
	
	void channelDown() {
		if (status == true) {
			if (channel > 1) {
				channel--; 
			} else {
				channel = 5; 
			}
			System.out.println("channel: " + channel);
		} 
		
	}
	
	void volumeUp() {
		if (status == true) {
			if(volume < MAX_VOLUME) {
				volume++; 
			} 
			System.out.println("volume: " + volume);
		} 
	
	} 
	
	void volumeDown() {
		if (status == true) {
			if(volume >= 1) {
				volume--; 
			} 
			System.out.println("volume: " + volume);
		} 
		
	}
	
}
