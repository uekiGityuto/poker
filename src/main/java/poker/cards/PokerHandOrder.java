package poker.cards;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ganba
 *
 * ポーカーの役を弱い順に並べたリスト。
 */
public class PokerHandOrder {
	private static List<String> pokerHandOrder = makePokerHandOrder();

	private PokerHandOrder() {
	};

	/**
	 * @return ポーカーの役を弱い順に並べたリスト。
	 */
	private static List<String> makePokerHandOrder() {
		List<String> pokerHandOrder = new ArrayList<>();
		pokerHandOrder.add("Nothing");
		pokerHandOrder.add("Pair");
		pokerHandOrder.add("Two Pair");
		pokerHandOrder.add("Three of a Kind");
		pokerHandOrder.add("Straight");
		pokerHandOrder.add("Flush");
		pokerHandOrder.add("Full House");
		pokerHandOrder.add("Four of a Kind");
		pokerHandOrder.add("Straight Flush");
		pokerHandOrder.add("Royal Straight Flush");

		return pokerHandOrder;
	}

	/**
	 * @return ポーカーの役を弱い順に並べたリスト
	 */
	// 【違反！！】Getter,Setter,publicプロパティの禁止
	public static List<String> getPokerHandOrder() {
		return pokerHandOrder;
	}

}
