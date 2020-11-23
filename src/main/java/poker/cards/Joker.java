package poker.cards;

/**
 * @author ganba
 *
 * Jokerのカード。
 */
public class Joker extends Card {

	public Joker() {
		this.number = null;
		this.suit = null;
	}

	@Override
	void display() {
		System.out.println("Joker");
	}

	@Override
	int getNumber() {
		return number.getNumber();
	}

	@Override
	String getSuit() {
		return suit.getSuit();
	}

	@Override
	public int compareTo(Card card) {
		return 1;
	}

}
