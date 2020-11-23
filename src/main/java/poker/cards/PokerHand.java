package poker.cards;

/**
 * @author ganba
 *
 * ポーカーの役とランク。
 */
public class PokerHand {
	private String pokerHand;
	private int rank;

	PokerHand(String pokerHand, int rank) {
		this.pokerHand = pokerHand;
		this.rank = rank;
	}

	/**
	 * @return この役
	 */
	// 【違反！！】Getter,Setter,publicプロパティの禁止
	public String getPokerHand() {
		return this.pokerHand;
	}

	/**
	 * @return このランク。
	 */
	// 【違反！！】Getter,Setter,publicプロパティの禁止
	public int getRank() {
		return this.rank;
	}

}
