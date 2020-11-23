package poker.cards;

/**
 * @author ganba
 *
 * トランプのスート。
 */
public class Suit {
	private String suit;

	Suit(String suit) {
		switch(suit) {
		case "Club":
			this.suit = suit;
			break;
		case "Diamond":
			this.suit = suit;
			break;
		case "Heart":
			this.suit = suit;
			break;
		case "Spade":
			this.suit = suit;
			break;
		default:
			throw new IllegalArgumentException("Club、Diamond、Heart、Spade以外は使用できません。");
		}
	}

	/**
	 * このスートを表示する。
	 */
	public void display() {
		System.out.print(this.suit);
	}

	/**
	 * @return このスート。
	 */
	// 【違反！！】Getter,Setter,publicプロパティの禁止
	public String getSuit() {
		return this.suit;
	}
}
