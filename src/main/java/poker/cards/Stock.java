package poker.cards;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * @author ganba
 *
 * トランプの山札。
 */
public class Stock {
	private static Deque<Card> stock = makeStock();

	private Stock() {};

	/**
	 * @return 山札を作る。
	 */
	private static Deque<Card> makeStock() {
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Joker());
		for (int i = 1; i < 14; i++) {
			cardList.add(new NormalCard("club", i));
			cardList.add(new NormalCard("diamond", i));
			cardList.add(new NormalCard("heart", i));
			cardList.add(new NormalCard("spade", i));
		}
		Collections.shuffle(cardList);
		Deque<Card> stock = new ArrayDeque<>();
		cardList.forEach(card -> stock.add(card));
		return stock;
	}

	/**
	 * @return 山札の一番上のカード。
	 */
	public static Card openTop() {
		return stock.pop();
	}
}
