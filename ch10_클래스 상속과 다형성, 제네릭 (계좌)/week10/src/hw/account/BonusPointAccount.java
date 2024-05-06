package hw.account;

// 포인트 적립 계좌 클래스 
public class BonusPointAccount extends Account {
	// >> 멤버 변수
	// 누적 포인트
	int bonusPoint;

	// >> 생성자
	public BonusPointAccount(String accountNo, String name, int balance) {
		super(accountNo, name, balance);
		this.bonusPoint += balance * (0.1 / 100);
	}

	// >> 메서드
	// 예금하기 (재정의)
	@Override
	public void deposit(int amount) {
		super.deposit(amount);
		this.bonusPoint += amount * (0.1 / 100);
	}

	// 잔액조회하기 (재정의)
	@Override
	public void check() {
		super.check();
		System.out.println("bonusPoint : " + bonusPoint);
	}

}
