// cal.add() 수행중일 때 cal.sub()은 수행되지 않아야 함(그 역도 성립해야 함)

class Calculator {
	private int opCnt = 0;

	int add(int n1, int n2) {
		synchronized (this) {
			opCnt++;
		}
		
		return n1 + n2;
	}

	int sub(int n1, int n2) {
		synchronized (this) {
			opCnt++;
		}
		
		return n1 - n2;
	}

	void showOpCnt() {
		System.out.println("총 연산 횟수: " + opCnt);
	}
}

class AddThread extends Thread {
	private Calculator cal;

	AddThread(Calculator cal) {
		this.cal = cal;
	}

	@Override
	public void run() {
		System.out.println("1 + 2 = " + cal.add(1, 2));
		System.out.println("2 + 4 = " + cal.add(2, 4));
	}
}

class MinThread extends Thread {
	private Calculator cal;

	MinThread(Calculator cal) {
		this.cal = cal;
	}

	@Override
	public void run() {
		System.out.println("2 - 1 = " + cal.sub(2, 1));
		System.out.println("4 - 2 = " + cal.sub(4, 2));
	}
}

class ThreadSyncMethod {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		AddThread at = new AddThread(cal);
		MinThread mt = new MinThread(cal);

		at.start();
		mt.start();

		try {
			at.join();
			mt.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		cal.showOpCnt();
	}
}