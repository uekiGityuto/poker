package poker.character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ganba
 *
 * ユーザーが操作するプレイヤー。
 */
//【違反！！】1つのクラスは50行、1ディレクトリは10ファイルまで
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
		System.out.println("交換したいカードの番号（0～4）をスペース区切りで入力し、Enterキーを押下して下さい。");
		System.out.println("交換しない場合は何も入力せずにEnterキーを押下して下さい。");
		System.out.println("例）1 3");

		String input = scanner.nextLine();
		scanner.close();

		if (input.equals("")) {
			System.out.println("交換しませんでした。");
			return;
		}

		List<String> strIndexes = Arrays.asList(input.split(" "));
		List<Integer> intIndexes = new ArrayList<>();
		for (String index : strIndexes) {
			checkIndex(index);
			intIndexes.add(Integer.parseInt(index));
		}
		hand.change(intIndexes);

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
