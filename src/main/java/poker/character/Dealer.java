package poker.character;

public class Dealer {
	private static Dealer singleton = new Dealer();

	private Dealer() {}

	/**
	 * @return Dealerインスタンス
	 */
	public static Dealer getInstance() {
		return singleton;
	}

	public void judge() {
		System.out.println("あなたの勝利です。");
		System.out.println("あなたの負けです。");
	}
}
