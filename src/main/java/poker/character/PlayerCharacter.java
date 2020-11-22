package poker.character;

import java.util.Scanner;

public class PlayerCharacter extends Player {

	@Override
	public void checkCard() {
		System.out.println("---");
		hand.display();
		System.out.println("---");
	}

	@Override
	public void changeCard() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("交換したいカードの番号（0～4）をスペース区切りで入力して下さい。");
		System.out.println("例）1 3");

		String input = scanner.nextLine();
		scanner.close();

		String[] indexes = input.split(" ");
		for (String index : indexes) {
			checkIndex(index);
			hand.change(Integer.parseInt(index));
		}

		System.out.println("交換しました。");
	}

	/**
	 * @param index
	 *
	 * 0～4の数字でなければゲームを異常終了。
	 */
	private void checkIndex(String index) {
		switch(index) {
		case "0": break;
		case "1": break;
		case "2": break;
		case "3": break;
		case "4": break;
		default:
			System.out.println("0～4の数字で入力して下さい。");
			System.out.println("ゲームを異常終了します。");
			System.exit(1);
		}
	}
}
