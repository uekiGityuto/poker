package poker.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ganba
 *
 * トランプの手札。
 */
//【違反！！】1つのクラスは50行、1ディレクトリは10ファイルまで
public class Hand {
	private List<Card> hand = new ArrayList<>();

	public Hand() {
		// 山札から5枚引いて手札にする
		for (int i = 0; i < 5; i++) {
			hand.add(Stock.openTop());
		}
		sortInAscByNum(hand);
	}

	/**
	 * 手札を表示する。
	 */
	public void display() {
		int i = 0;
		for (Card card : hand) {
			System.out.print(i++ + ". ");
			card.display();
		}
	}

	/**
	 * @param i
	 *
	 * i番目の手札を交換する。
	 */
	public void change(int i) {
		hand.set(i, Stock.openTop());
		sortInAscByNum(hand);
	}

	/**
	 * @return 手札から作れる（最高の）ポーカーの役。
	 *
	 * ※一旦、ジョーカーは考慮しない。
	 */
	public String decidePokerHand() {
		if (isRoyalStraightFlush(hand)) {
			return "Royal Straight Flush";
		}
		if (isStraightFlush(hand)) {
			return "Straight Flush";
		}
		if (isFullHouse(hand)) {
			return "Four of a Kind";
		}
		if (isFullHouse(hand)) {
			return "Full House";
		}
		if (isFlush(hand)) {
			return "Flush";
		}
		if (isStraight(hand)) {
			return "Straight";
		}
		if (isTriple(hand)) {
			return "Three of a Kind";
		}
		if (isTwoPair(hand)) {
			return "Two Pair";
		}
		if (isPair(hand)) {
			return "Pair";
		}
		return "Nothing";
	}

	/**
	 * 数字の昇順でソートする。
	 */
	public void sortInAscByNum(List<Card> hand) {
		Collections.sort(hand);
	}

	/**
	 * @param hand
	 * @return ストレートフラッシュかどうか。
	 */
	private boolean isRoyalStraightFlush(List<Card> hand) {
		if (isRoyal(hand) && isStraightFlush(hand)) {
			return true;
		}
		return false;
	}

	/**
	 * @param hand
	 * @return ストレートフラッシュかどうか。
	 */
	private boolean isStraightFlush(List<Card> hand) {
		if (isStraight(hand) && isFlush(hand)) {
			return true;
		}
		return false;
	}

	/**
	 * @param hand
	 * @return フォーカードかどうか。
	 */
	private boolean isFourth(List<Card> hand) {
		boolean isFourth = false;
		for (int i = 3; i < 5; i++) {
			// 【違反！！】メソッド内のインデントは1段まで
			if (isSameNum(hand.get(i - 3), hand.get(i - 2), hand.get(i - 1), hand.get(i))) {
				isFourth = true;
				break;
			}
		}
		return isFourth;
	}

	/**
	 * @param hand
	 * @return フルハウスかどうか。
	 */
	private boolean isFullHouse(List<Card> hand) {
		int sameNum = 0;
		for (int i = 1; i < 5; i++) {
			sameNum += isSameNum(hand.get(i - 1), hand.get(i)) ? 1 : 0;
		}
		if (sameNum == 3 && !isFourth(hand)) {
			return true;
		}
		return false;
	}

	/**
	 * @param hand
	 * @return フラッシュかどうか。
	 */
	private boolean isFlush(List<Card> hand) {
		boolean isFlush = true;
		for (int i = 1; i < 5; i++) {
			// 【違反！！】メソッド内のインデントは1段まで
			if (!isSameSuit(hand.get(i - 1), hand.get(i))) {
				isFlush = false;
				break;
			}
		}
		return isFlush;
	}

	/**
	 * @param hand
	 * @return ストレートかどうか。
	 */
	private boolean isStraight(List<Card> hand) {
		boolean isStraight = true;
		for (int i = 1; i < 5; i++) {
			// 【違反！！】メソッド内のインデントは1段まで
			if (!isSameNum(hand.get(i - 1), hand.get(i))) {
				isStraight = false;
				break;
			}
		}
		return isStraight;
	}

	/**
	 * @param hand
	 * @return スリーカードかどうか。
	 */
	private boolean isTriple(List<Card> hand) {
		boolean isTriple = false;
		for (int i = 2; i < 5; i++) {
			// 【違反！！】メソッド内のインデントは1段まで
			if (isSameNum(hand.get(i - 2), hand.get(i - 1), hand.get(i))) {
				isTriple = true;
				break;
			}
		}
		return isTriple;
	}

	/**
	 * @param hand
	 * @return ツーペアかどうか。
	 */
	private boolean isTwoPair(List<Card> hand) {
		int pairNum = 0;
		for (int i = 1; i < 5; i++) {
			pairNum += isSameNum(hand.get(i - 1), hand.get(i)) ? 1 : 0;
		}
		if (pairNum == 2) {
			return true;
		}
		return false;
	}

	/**
	 * @param hand
	 * @return ワンペアかどうか。
	 */
	private boolean isPair(List<Card> hand) {
		int pairNum = 0;
		for (int i = 1; i < 5; i++) {
			pairNum += isSameNum(hand.get(i - 1), hand.get(i)) ? 1 : 0;
		}
		if (pairNum == 1) {
			return true;
		}
		return false;
	}

	/**
	 * @param hand
	 * @return カードの数字が1,10,11,12,13であるかどうか。
	 */
	private boolean isRoyal(List<Card> hand) {
		// 【違反！！】1行につきドットは1つまで
		if (hand.get(0).getNumber() == 1 &&
				hand.get(1).getNumber() == 10 &&
				hand.get(2).getNumber() == 11 &&
				hand.get(3).getNumber() == 12 &&
				hand.get(3).getNumber() == 13) {
			return true;
		}
		return false;
	}

	/**
	 * @param カード1
	 * @param カード2
	 * @return カード1とカード2のスートが一致しているかどうか。
	 */
	private boolean isSameSuit(Card c1, Card c2) {
		// 【違反！！】1行につきドットは1つまで
		if (c1.getSuit().equals(c2.getSuit())) {
			return true;
		}
		return false;
	}

	/**
	 * @param カード1
	 * @param カード2
	 * @return カード1とカード2の数字が一致しているかどうか。
	 */
	private boolean isSameNum(Card c1, Card c2) {
		if (c1.getNumber() == c2.getNumber()) {
			return true;
		}
		return false;
	}

	/**
	 * @param カード1
	 * @param カード2
	 * @param カード3
	 * @return カード1とカード2とカード3の数字が一致しているかどうか。
	 */
	private boolean isSameNum(Card c1, Card c2, Card c3) {
		if (c1.getNumber() == c2.getNumber() && c2.getNumber() == c3.getNumber()) {
			return true;
		}
		return false;
	}

	/**
	 * @param カード1
	 * @param カード2
	 * @param カード3
	 * @param カード4
	 * @return カード1とカード2とカード3とカード4の数字が一致しているかどうか。
	 */
	private boolean isSameNum(Card c1, Card c2, Card c3, Card c4) {
		if (c1.getNumber() == c2.getNumber() && c2.getNumber() == c3.getNumber()
				&& c3.getNumber() == c4.getNumber()) {
			return true;
		}
		return false;
	}

}
