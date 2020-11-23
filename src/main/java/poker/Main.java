package poker;
import poker.character.Player;
import poker.character.PlayerCharacter;

public class Main {

	public static void main(String[] args) {
		Player you = new PlayerCharacter();
		you.checkCard();
		you.changeCard();
		you.checkCard();
		System.out.println(you.openPokerHand());
	}

}
