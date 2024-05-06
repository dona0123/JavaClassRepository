package hw.account;

// 직불 계좌 클래스 
public class CheckingAccount extends Account {

	// >> 멤버 변수
	// 카드번호
	String cardNo;

	// >> 생성자
	public CheckingAccount(String accountNo, String name, int balance, String cardNo) {
		super(accountNo, name, balance);
		this.cardNo = cardNo;
	}

	// >> 메서드
	// 구매 메서드
	public int pay(String cardNo, int amount) { 
		if (this.cardNo.equals(cardNo)) {
			return this.withdraw(amount);
		}
		return 0;
	}
}
