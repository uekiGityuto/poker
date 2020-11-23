package poker.strategy;

import poker.cards.Hand;

/**
 * @author ganba
 *
 * NonPlayerCharacterの戦略。
 */
public interface Strategy {

	/**
	 * @param hand 交換前の手札
	 * @return 交換後の手札
	 */
	abstract Hand changeCard(Hand hand);
}
