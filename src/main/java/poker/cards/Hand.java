package poker.cards;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ganba
 *
 * トランプの手札。
 */
public class Hand {
	private List<Card> hand = new ArrayList<>();

	public Hand() {
		// 山札から5枚引いて手札にする
		for(int i = 0; i < 5; i++) {
			hand.add(Stock.openTop());
		}
	}

	/**
	 * 手札を表示する。
	 */
	public void display() {
		int i = 0;
		for(Card card : hand) {
			System.out.print(i++ + ". ");
			card.display();
		}
	}

	/**
	 * @param i
	 *
	 * 手札を交換する。
	 */
	public void change(int i) {
		hand.set(i, Stock.openTop());
	}
}
