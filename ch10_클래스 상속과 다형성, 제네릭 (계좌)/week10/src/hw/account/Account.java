package hw.account;

import java.util.Objects;

//사용자 정의 예외 클래스  
// 입출금 금액이 음수인 예외 
@SuppressWarnings("serial")
class MalformedDataException extends Exception {
	public MalformedDataException(String message) {
		super(message);
	}
}

// 잔액을 초과한 예외 
@SuppressWarnings("serial")
class BalanceOutOfBoundException extends RuntimeException {
	public BalanceOutOfBoundException(String message) {
		super(message);
	}
}

// 기본 계좌 클래스 
public class Account {

	// >> 멤버 필드
	// 계좌번호
	String accountNo;

	// 예금주 이름
	String name;

	// 잔액
	int balance;

	// >> 생성자
	public Account(String accountNo, String name, int balance) {
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}

	// >> 멤버 메서드
	// 예금하기
	public void deposit(int amount) {

		try {
			if (amount < 0) {
				throw new MalformedDataException("error: Deposit amount cannot be negative");
			}
			balance += amount;
		} catch (MalformedDataException e) {
			System.out.println(e.getMessage());
		}
	}

	// 인출하기
	public int withdraw(int amount) {
		try {
			if (balance < amount) {
				throw new BalanceOutOfBoundException("error: Insufficient balance");
			}

			if (amount < 0) {
				throw new MalformedDataException("error: Deposit amount cannot be negative");
			}

			balance -= amount;
			return amount;
		} catch (BalanceOutOfBoundException e) {
			System.out.println(e.getMessage());
			return 0;
		} catch (MalformedDataException e) {
			System.out.println(e.getMessage());
			return 0;
		}

	}

	// 잔액조회하기
	public void check() {
		System.out.println("[" + accountNo + "] :" + name);
		System.out.println("balance : " + balance);
	}
	
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }
	        Account account = (Account) obj;
	        return Objects.equals(accountNo, account.accountNo);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(accountNo);
	    }

} 
