package hw.account;

// 마이너스 통장 클래스 
public class CreditLineAccount extends Account {
	
	// >> 멤버 변수
	// 마이너스 한도 
	int creditLine;
	
	// >> 생성자 
	public CreditLineAccount(String accountNo, String name, int balance, int creditLine) {
		super(accountNo, name, balance);
		this.creditLine = creditLine; 
	}
	
	// >> 메서드 
	// 인출하기 (재정의) 
	@Override
	public int withdraw(int amount) { 
		if(balance + creditLine < amount) {
			System.out.println("!! Insufficient balance !!");
			return 0;
		}
		balance -= amount;
		return amount;
	} 
	
}
