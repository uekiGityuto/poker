package poker.character;

import poker.strategy.Strategy;

/**
 * @author ganba
 *
 * コンピューターが操作するプレイヤー。
 */
public class NonPlayerCharacter extends Player {
	private Strategy strategy;

	public NonPlayerCharacter(Strategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public void checkCard() {

	}

	@Override
	public void changeCard() {
		this.hand = strategy.changeCard(this.hand);
	}

}
