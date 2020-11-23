package poker.character;

import poker.cards.Hand;

/**
 * @author ganba
 *
 * ポーカーのプレイヤー。
 */
public abstract class Player {
	protected Hand hand;

	public Player() {
		hand = new Hand();
	}

	/**
	 * 手札を確認する。
	 */
	public abstract void checkCard();

	/**
	 * 手札を交換する。
	 */
	public abstract void changeCard();

	/**
	 * @return 手札で完成した役。
	 */
	public String getPokerHand() {
		return hand.getPokerHand();
	}

	/**
	 * @return 手札で完成したランク。
	 */
	public int getRank() {
		return hand.getRank();
	}
}
