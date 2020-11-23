package poker.cards;

/**
 * @author ganba
 *
 * トランプの数字。
 */
public class Number {
	private int number;

	Number(int number) {
		if(number <= 0 || 14 <= number) {
			throw new IllegalArgumentException("0以下、または、14以上の数字は使用できません。");
		}
		this.number = number;
	}

	/**
	 * @return ポーカーにおけるこの数字のランク。（大きい方が価値が高い）
	 */
	int getRank() {
		if(this.number == 1) {
			return 14;
		}
		return this.number;
	}

	/**
	 * この数字を表示する。
	 */
	void display() {
		if(this.number < 10) {
			System.out.print(" " + this.number);
			return;
		}
		System.out.print(this.number);
	}

	/**
	 * @return この数字。
	 */
	// 【違反！！】Getter,Setter,publicプロパティの禁止
	int getNumber() {
		return this.number;
	}
}
