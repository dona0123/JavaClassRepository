package ex.lotto;

import java.util.Random;

public class Lotto {

	// >> 멤버 변수
	// 로또 번호
	private int[] mLottoNumber = new int[6];

	// 로또번호의 유효성 검사 결과 저장
	private boolean mIsValid;

	
	
	// >> 생성자
	// 인자 있는 생성자 : 매개변수로 정수 6개
	public Lotto(int a, int b, int c, int d, int e, int f) {
		int[] nArray = { a, b, c, d, e, f };
		this.mIsValid = verify(nArray);
		for (int i = 0; i < nArray.length; i++) {
			this.mLottoNumber[i] = nArray[i];
		}
	}

	// 인자 있는 생성자 : 매개변수로 정수 배열
	public Lotto(int[] nArray) {
		this.mIsValid = verify(nArray);
		for (int i = 0; i < nArray.length; i++) {
			this.mLottoNumber[i] = nArray[i];
		}
	}
	
	// 인자 없는 생성자
	public Lotto() {
		this.generate();
		this.mIsValid = true;
	}

	
	
	// >> 메서드
	// 로또번호 자동생성
	public void generate() {
		int n, count = 1;
		boolean set;
		Random random = new Random();
		this.mLottoNumber[0] = random.nextInt(45) + 1;

		while (count < this.mLottoNumber.length) {
			set = true;
			n = random.nextInt(45) + 1;

			for (int i = 0; i < count; i++) {
				if (this.mLottoNumber[i] == n) {
					set = false;
					break;
				}
			}

			if (set) {
				this.mLottoNumber[count] = n;
				count++;
			}
		}
	}

	// 로또번호의 유효성 검사하기 (숫자 개수, 숫자 범위, 중복 유무)
	public boolean verify(int[] nArray) {
		int i, j;

		if (nArray.length != 6) {
			return false;
		}

		for (i = 0; i < nArray.length; i++) {
			if (!(0 < nArray[i] && nArray[i] < 46)) {
				return false;
			}
		}

		for (i = 0; i < nArray.length; i++) {
			for (j = i + 1; j < nArray.length; j++) {
				if (nArray[i] == nArray[j]) {
					return false;
				}
			}
		}

		return true;

	}

	// 로또번호 출력하기
	public void show() {
		if (!this.mIsValid) {
			System.out.print("!!error!! ");
		}

		for (int i = 0; i < this.mLottoNumber.length; i++) {
			System.out.print(this.mLottoNumber[i] + " ");
		}
	}

	// 로또번호 반환하기
	public int[] getNumbers() {
		if (this.mIsValid) {
			return this.mLottoNumber;
		} return null;
	}

}
