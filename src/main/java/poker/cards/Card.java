package poker.cards;

/**
 * @author ganba
 *
 * トランプのカード。
 */
public abstract class Card implements Comparable<Card>{

	protected Suit suit;
	protected Number number;

	/**
	 * カードを表示する。
	 */
	abstract void display();

	/**
	 * @return トランプのスート
	 */
	// 【違反！！】Getter,Setter,publicプロパティの禁止
	abstract String getSuit();

	/**
	 * @return トランプの数字
	 */
	// 【違反！！】Getter,Setter,publicプロパティの禁止
	abstract int getNumber();
}
