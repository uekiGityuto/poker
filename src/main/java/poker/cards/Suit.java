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
		case "club":
			this.suit = suit;
			break;
		case "diamond":
			this.suit = suit;
			break;
		case "heart":
			this.suit = suit;
			break;
		case "spade":
			this.suit = suit;
			break;
		default:
			throw new IllegalArgumentException("club、diamond、heart、spade以外は使用できません。");
		}
	}

	/**
	 * このスートを表示する。
	 */
	public void display() {
		System.out.print(this.suit);
	}
}
