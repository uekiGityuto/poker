package poker;
import poker.character.Dealer;
import poker.character.NonPlayerCharacter;
import poker.character.Player;
import poker.character.PlayerCharacter;
import poker.strategy.NothingStrategy;

public class Main {

	public static void main(String[] args) {
		Player you = new PlayerCharacter();
		Player npc = new NonPlayerCharacter(new NothingStrategy());

		you.checkCard();
		you.changeCard();
		you.checkCard();

		npc.changeCard();

		Dealer dealer = Dealer.getInstance();
		dealer.judge(you.getPokerHand(), npc.getPokerHand());
	}

}
