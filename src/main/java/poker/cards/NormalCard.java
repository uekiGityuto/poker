package poker.cards;

/**
 * @author ganba
 *
 * Joker以外のカード。
 */
public class NormalCard implements Card {
	private Suit suit;
	private Number number;

	public NormalCard(String suit, int number) {
		this.suit = new Suit(suit);
		this.number = new Number(number);
	}

	@Override
	public void display() {
		number.display();
		System.out.print(" of ");
		suit.display();
		System.out.println();
	}

}
