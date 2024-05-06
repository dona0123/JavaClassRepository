// num1에 대한 동기화 처리 메서드와 num2에 대한 동기화 처리는 배타적일 필요 없음

class IHaveTwoNum {
	private int num1 = 0;
	private int num2 = 0;
	
	private Object key1 = new Object();  
	private Object key2 = new Object();  


	void addOneNum1() {
		synchronized (key1) {
			num1 += 1;
		}
		
	}

	void addTwoNum1() {
		synchronized (key1) {
			num1 += 2;
		}
	}

	 void addOneNum2() {
		synchronized (key2) {
				num2 += 1;
		}
	
	}

	 void addTwoNum2() {
		synchronized (key2) {
			num2 += 2;
	}

	
	}

	void showAllNums() {
		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);
	}
}

class AccessThread extends Thread {
	private IHaveTwoNum twoNumInst;

	AccessThread(IHaveTwoNum inst) {
		twoNumInst = inst;
	}

	@Override
	public void run() {
		twoNumInst.addOneNum1();
		twoNumInst.addTwoNum1();

		twoNumInst.addOneNum2();
		twoNumInst.addTwoNum2();
	}
}

class SyncObjectKey {
	public static void main(String[] args) {
		IHaveTwoNum numInst = new IHaveTwoNum();

		AccessThread at1 = new AccessThread(numInst);
		AccessThread at2 = new AccessThread(numInst);

		at1.start();
		at2.start();

		try {
			at1.join();
			at2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		numInst.showAllNums();
	}
}