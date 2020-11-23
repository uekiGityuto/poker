package poker.strategy;

import poker.cards.Hand;

/**
 * @author ganba
 *
 * 何もしない戦略。
 */
public class NothingStrategy implements Strategy {

	@Override
	public Hand changeCard(Hand hand) {
		return hand;
	}

}
