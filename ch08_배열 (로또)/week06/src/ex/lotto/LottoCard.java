package ex.lotto;

public class LottoCard {

	// >> 멤버 변수
	// 로또복권 객체의 배열
	private Lotto[] mLottos;

	// 구매한 로또복권의 개수(1~5)
	private int mNum;
	
	

	// >> 생성자
	public LottoCard(int mNum) {
		if (0 < mNum && mNum < 6) {
			this.mNum = mNum;
			this.mLottos = new Lotto[mNum];
		}
	}

	
	
	// >> 메서드
	// idx번쨰 로또복권을 자동설정
	public boolean auto(int idx) {
		if (1 <= idx && idx <= mNum) {
			this.mLottos[idx - 1] = new Lotto();
			return true;
		} return false;
	}

	// idx번쨰 로또복권을 수동설정
	public boolean manual(int idx, int a, int b, int c, int d, int e, int f) {
		if (1 <= idx && idx <= mNum) {
			this.mLottos[idx - 1] = new Lotto(a, b, c, d, e, f);
			return true;
		} return false;
	}

	public boolean manual(int idx, int[] nArray) {
		if (1 <= idx && idx <= mNum) {
			this.mLottos[idx - 1] = new Lotto(nArray);
			return true;
		} return false;
	}
	
	// 카드에 설정된 idx번쨰 로또복권의 번호 반환
	public int[] get(int idx) {
		return this.mLottos[idx - 1].getNumbers();
	}

	// 카드에 설정된 유효 로또복권의 번호 출력
	public void show() {

		for (int i = 0; i < mNum; i++) {
			System.out.print("Lotto" + (i + 1) + ": ");
			this.mLottos[i].show();
			System.out.println();
		}

	}

}
