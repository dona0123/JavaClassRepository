package hw.account;

import java.util.HashSet;
import java.util.Objects;
import java.util.Vector;



public class Bank {

	public static void main(String[] args) {

		// 배열
		Account[] aList = new Account[5];
		aList[0] = new Account("152-123", "professor", 1000);
		aList[1] = new CheckingAccount("457-284", "croquette", 1000, "01");
		aList[2] = new CheckingTrafficCardAccount("205-682", "bear", 1000, "02");
		aList[3] = new CreditLineAccount("708-274", "princess", 1000, 40000);
		aList[4] = new BonusPointAccount("892-802", "starfish", 1000);

		// 백터 활용 (유지되는 개수가 자동으로 늘어남)
		System.out.println("=======Vector=======");
		Vector<Account> accountVector = new Vector<Account>();

		for (Account a : aList) {
			accountVector.add(a);
		}
		accountVector.add(new Account("152-123", "professor", 1000));

		for (Account a : accountVector) {
			if (a instanceof CheckingAccount) {
				((CheckingAccount) a).pay("01", 100);
			}
			if (a instanceof CheckingTrafficCardAccount) {
				((CheckingTrafficCardAccount) a).payTrafficCard("02", 200);
			}
			if (a instanceof CreditLineAccount) {
				a.withdraw(40000);
			}
			if (a instanceof BonusPointAccount) {
				a.deposit(-1000);
			}

			a.check();
			System.out.println("\n");
		}

		// 해시 활용 (동일 계좌 중복 삽입이 불가)
		System.out.println("=======Hash=======");
		HashSet<Account> accountHash = new HashSet<Account>();

		for (Account a : aList) {
			accountHash.add(a);
		}
		accountHash.add(new Account("152-123", "professor", 1000));

		for (Account a : accountHash) {
			if (a instanceof CheckingAccount) {
				((CheckingAccount) a).pay("01", 100);
			}
			if (a instanceof CheckingTrafficCardAccount) {
				((CheckingTrafficCardAccount) a).payTrafficCard("02", 200);
			}
			if (a instanceof CreditLineAccount) {
				a.withdraw(40000);
			}
			if (a instanceof BonusPointAccount) {
				a.deposit(-1000);
			}

			a.check();
			System.out.println("\n");
		}

	}

	
}
