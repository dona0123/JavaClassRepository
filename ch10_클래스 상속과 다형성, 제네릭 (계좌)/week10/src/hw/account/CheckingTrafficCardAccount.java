package hw.account;

// 교통카드 기능이 있는 직불 계좌 클래스 
public class CheckingTrafficCardAccount extends CheckingAccount {

	// >> 멤버 변수
	// 교통카드 여부
	boolean hasTrafficCard;

	// >> 생성자
	public CheckingTrafficCardAccount(String accountNo, String name, int balance, String cardNo) {
		super(accountNo, name, balance, cardNo);
		this.hasTrafficCard = true;
	}

	// >> 메서드
	// 교통카드 지불
	public int payTrafficCard(String cdNo, int amount) {
		if (this.hasTrafficCard) {
			return this.pay(cdNo, amount);
		}
		System.out.println("!! Is not TrafficCard !!");
		return 0;
	}
}
