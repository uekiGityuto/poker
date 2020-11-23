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
//【違反！！】1つのクラスにつきインスタンス変数は2つまで
public class Hand {
	private List<Card> hand = new ArrayList<>();
	private String pokerHand;
	private int rank;

	public Hand() {
		// 山札から5枚引いて手札にする
		for (int i = 0; i < 5; i++) {
			hand.add(Stock.openTop());
		}
		sortInAscByNum(hand);
		setPokerHandAndRank();
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
		setPokerHandAndRank();
	}

	/**
	 * 手札から作れる（最高の）ポーカーの役とランクをセットする。
	 * ※一旦、ジョーカーは考慮しない。
	 */
	private void setPokerHandAndRank() {
		if (isRoyalStraightFlush(hand)) {
			return;
		}
		if (isStraightFlush(hand)) {
			return;
		}
		if (isFourth(hand)) {
			return;
		}
		if (isFullHouse(hand)) {
			return;
		}
		if (isFlush(hand)) {
			return;
		}
		if (isStraight(hand)) {
			return;
		}
		if (isTriple(hand)) {
			return;
		}
		if (isTwoPair(hand)) {
			return;
		}
		if (isPair(hand)) {
			return;
		}
		this.pokerHand = "Nothing";
		this.rank = 0;
	}

	/**
	 * @return この手札の役
	 */
	// 【違反！！】Getter,Setter,publicプロパティの禁止
	public String getPokerHand() {
		return this.pokerHand;
	}

	/**
	 * @return この手札のランク
	 */
	// 【違反！！】Getter,Setter,publicプロパティの禁止
	public int getRank() {
		return this.rank;
	}

	/**
	 * 数字の昇順でソートする。
	 */
	public void sortInAscByNum(List<Card> hand) {
		Collections.sort(hand);
	}

	/**
	 * @param hand
	 * @return ロイヤルストレートフラッシュかどうか。
	 */
	private boolean isRoyalStraightFlush(List<Card> hand) {
		if (isRoyal(hand) && isStraightFlush(hand)) {
			this.pokerHand = "Royal Straight Flush";
			this.rank = 99;
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
			this.pokerHand = "Straight Flush";
			// 【違反！！】1行につきドットは1つまで
			this.rank = hand.get(4).getRank();
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
				this.pokerHand = "Four of a Kind";
				// 【違反！！】1行につきドットは1つまで
				this.rank = hand.get(i).getRank();
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
		boolean isFullHouse = false;
		for (int i = 2; i < 5; i++) {
			// 【違反！！】メソッド内のインデントは1段まで
			if (isSameNum(hand.get(i - 2), hand.get(i - 1), hand.get(i))) {
				List<Card> restHand = makeRestHand(hand, i);
				if(isSameNum(restHand.get(0), restHand.get(1))) {
					isFullHouse = true;
					this.pokerHand = "Full House";
					// 【違反！！】1行につきドットは1つまで
					this.rank = hand.get(i).getRank();
				}
				break;
			}
		}
		return isFullHouse;
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
		if(isFlush) {
			this.pokerHand = "Flush";
			// 【違反！！】1行につきドットは1つまで
			this.rank = hand.get(4).getRank();
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
		if(isStraight) {
			this.pokerHand = "Straight";
			// 【違反！！】1行につきドットは1つまで
			this.rank = hand.get(4).getRank();
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
				this.pokerHand = "Three of a Kind";
				// 【違反！！】1行につきドットは1つまで
				this.rank = hand.get(i).getRank();
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
		int pairCount = 0;
		List<Integer> pairNumList = new ArrayList<>(); // ペアになった数字のリスト
		for (int i = 1; i < 5; i++) {
			if(isSameNum(hand.get(i - 1), hand.get(i))) {
				pairCount += 1;
				pairNumList.add(hand.get(i).getRank());
			}
		}
		if (pairCount == 2) {
			this.pokerHand = "Two Pair";
			this.rank = Collections.max(pairNumList);
			return true;
		}
		return false;
	}

	/**
	 * @param hand
	 * @return ワンペアかどうか。
	 */
	private boolean isPair(List<Card> hand) {
		int pairCount = 0;
		int pairNum = 0; // ペアになった数字
		for (int i = 1; i < 5; i++) {
			// 【違反！！】メソッド内のインデントは1段まで
			if(isSameNum(hand.get(i - 1), hand.get(i))) {
				pairCount += 1;
				// 【違反！！】1行につきドットは1つまで
				pairNum = hand.get(i).getRank();
			}
		}
		if (pairCount == 1) {
			this.pokerHand = "Pair";
			this.rank = pairNum;
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
	 * @param hand
	 * @param i
	 * @return 手札から3枚の同じ数字を除いた残り
	 *
	 * 手札を数字の小さい順にa,b,c,d,eとしたとき、
	 * 3枚同じ数字になりうるのは「a,b,c」、「b,c,d」、「c,d,e」の3パターンのみ。
	 * a,b,c,d,eの添え字はそれぞれ0,1,2,3,4だから、添え字をiとすると、
	 * 3枚同じ数字になるのは、(i-2)+(i-1)+iが3,6,9となる3パターンのみ。
	 * この3パターンで場合分けして、手札から3枚の同じ数字を除いた残りを作る。
	 */
	private List<Card> makeRestHand(List<Card> hand, int i) {
		List<Card> restHand = new ArrayList<>();
		if(i == 2) {
			restHand.add(hand.get(3));
			restHand.add(hand.get(4));
		}
		if(i == 3) {
			restHand.add(hand.get(0));
			restHand.add(hand.get(4));
		}
		if(i == 4) {
			restHand.add(hand.get(0));
			restHand.add(hand.get(1));
		}
		return restHand;
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
