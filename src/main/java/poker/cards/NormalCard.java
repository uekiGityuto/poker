package poker.cards;

/**
 * @author ganba
 *
 * Joker以外のカード。
 */
public class NormalCard extends Card {

	public NormalCard(String suit, int number) {
		this.suit = new Suit(suit);
		this.number = new Number(number);
	}

	@Override
	void display() {
		number.display();
		System.out.print(" of ");
		suit.display();
		System.out.println();
	}

	@Override
	String getSuit() {
		return suit.getSuit();
	}

	@Override
	int getNumber() {
		return number.getNumber();
	}

	@Override
	public int compareTo(Card card) {
		if (this.getNumber() < card.getNumber()) {
			return -1;
		}
		if (this.getNumber() > card.getNumber()) {
			return 1;
		}
		return 0;
	}
}
