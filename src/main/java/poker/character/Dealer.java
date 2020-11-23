package poker.character;

import java.util.List;

import poker.cards.PokerHandOrder;

/**
 * @author ganba
 *
 * ディーラー。
 */
//【違反！！】1つのクラスは50行、1ディレクトリは10ファイルまで
public class Dealer {
	private static Dealer singleton = new Dealer();

	private Dealer() {
	}

	/**
	 * @return Dealerインスタンス
	 */
	public static Dealer getInstance() {
		return singleton;
	}

	/**
	 * @param pcHand PlayerCharacterの手札で完成した役。
	 * @param npcHand NonPlayerCharacterの手札で完成した役。
	 *
	 * 勝敗を判定する。
	 */
	public void judge(String pcHand, String npcHand) {
		System.out.println("あなたの役は" + pcHand + "です。");
		System.out.println("相手の役は" + npcHand + "です。");

		List<String> pokerHandOrder = PokerHandOrder.getPokerHandOrder();

		int pcOrder = 0;
		for (String pokerHand : pokerHandOrder) {
			// 【違反！！】メソッド内のインデントは1段まで
			if (pokerHand == pcHand) {
				break;
			}
			pcOrder++;
		}
		if (pcOrder == pokerHandOrder.size()) {
			System.out.println("判定不能です。");
			return;
		}

		int npcOrder = 0;
		for (String pokerHand : pokerHandOrder) {
			// 【違反！！】メソッド内のインデントは1段まで
			if (pokerHand == npcHand) {
				break;
			}
			npcOrder++;
		}
		if (npcOrder == pokerHandOrder.size()) {
			System.out.println("判定不能です。");
		}

		if (pcOrder < npcOrder) {
			System.out.println("あなたの負けです。");
			return;
		}
		if (pcOrder > npcOrder) {
			System.out.println("あなたの勝利です。");
			return;
		}
		if (pcOrder == npcOrder) {
			System.out.println("引き分けです。");
			return;
		}
		System.out.println("判定不能です。");
	}

}
