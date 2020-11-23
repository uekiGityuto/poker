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
	String getSuit() {
		return "Joker";
	}


	@Override
	int getNumber() {
		return 99;
	}

	@Override
	int getRank() {
		return 99;
	}

	@Override
	public int compareTo(Card card) {
		return 1;
	}

}
